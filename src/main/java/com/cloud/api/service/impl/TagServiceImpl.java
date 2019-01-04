package com.cloud.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.core.exception.ResourcesNotFoundException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.RegionDTO;
import com.cloud.api.dto.ImageDTO;
import com.cloud.api.dto.LayerDTO;
import com.cloud.api.dto.RegistryDTO;
import com.cloud.api.dto.TagDTO;
import com.cloud.api.dto.TagDTOExample;
import com.cloud.api.dto.TagDTOExample.Criteria;
import com.cloud.api.entity.ImageUploadDO;
import com.cloud.api.entity.MqMessage;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.TagRequestData;
import com.cloud.api.mapper.RegionMapper;
import com.cloud.api.mapper.TagMapper;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.ImageService;
import com.cloud.api.service.LayerService;
import com.cloud.api.service.MQMessageService;
import com.cloud.api.service.RegistryService;
import com.cloud.api.service.TagService;
import com.cloud.api.util.ClientConstants;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.MessageUtils;

/**
 * @author huang_kefei
 * @date 2018年9月30日 类说明
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TagServiceImpl extends BaseService implements TagService {

	@Resource
	private TagMapper tagMapper;

	@Resource
	private LayerService layerService;

	@Resource
	private ImageService imageService;

	@Resource
	private MQMessageService mQMessageService;

	@Resource
	private RegistryService registryService;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private RegionMapper regionMapper;
	
	private final static Logger log = LoggerFactory.getLogger(TagServiceImpl.class);
	
	@Override
	public boolean addTag(TokenDO token, TagRequestData requestData, String imageId, String project) {
		RegionDTO regionDTO = regionMapper.selectByPrimaryKey(MDC.get(MDCConstants.REGION_ID));
		if(regionDTO==null) {
			throw new ParamInvalidException("the current region does not exist in db!");
		}
		if (countByNameAndImageId(requestData.getTagName(), imageId) > 0) {
			throw new ParamInvalidException(MessageUtils.getMessage("tag.name.already.exists"));
		}
		ImageDTO image = imageService.queryImageById(imageId);
		if (image == null) {
			throw new ParamInvalidException("image不存在");
		}
		System.out.println("======================休眠========================");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("======================开始上传tag=========================");
		// 调用openshift,上传tag
		String imageName = image.getName();
		String param = imageName + ":" + requestData.getTagName();
		String registryUrl = "";
		if (Constants.REGISTRY_TYPE_PLATFORM.equals(image.getRegistryType())) {
			ProjectDTO projectDTO = projectService.queryProjectById(image.getProjectId());
			param = projectDTO.getName() + ":" + param;
			registryUrl = ClientConstants.URL_HTTPS + token.getUserName() + ":" + token.getTokenId() + "@"
					+ ClientConstants.OPENSHIFT_REGISTRY_URL;
		} else if (Constants.REGISTRY_TYPE_THIRD.equals(image.getRegistryType())) {
			RegistryDTO registry = registryService.queryRegistryById(image.getRegistryId());
			String[] urlArr = registry.getUrl().split("//");
			registryUrl = urlArr[0] + "//" + registry.getUserName() + ":" + registry.getPassword() + "@" + urlArr[1];
		}else if(Constants.REGISTRY_TYPE_PRIVATE.equals(image.getRegistryType())) {
			RegistryDTO registry = registryService.queryRegistryById(image.getRegistryId());
			registryUrl = registry.getUrl();
		}

		// 需要上传的文件名
		ImageUploadDO uploadDO = new ImageUploadDO(requestData.getFile());
		Invocation<TagDTO> invocationUpload = post(TagDTO.class, "/tools/docker/images/" + param, null)
				.endpoint(regionDTO.getContainerUrl()).header(ClientConstants.REGISTRY_URL, registryUrl)
				.header(ClientConstants.CONTENT_TYPE, ClientConstants.CONTENT_TYPE_JSON).entity(uploadDO);
		invocationUpload.executeWithResponse();
		TagDTO tagDTO = new TagDTO();
		tagDTO.setUuid(IdGen.uuid());
		tagDTO.setChangelog(requestData.getChangelog());
		tagDTO.setImageId(imageId);
		tagDTO.setName(requestData.getTagName());
		int ret = tagMapper.insertSelective(tagDTO);
		if (ret == 1) {
			log.info("=========send mq==========");
			MqMessage message = new MqMessage();
			message.setTokenDO(token);
			message.setTagName(requestData.getTagName());
			message.setProject(project);
			message.setType(image.getRegistryType());
			message.setImageName(imageName);
			message.setUuid(tagDTO.getUuid());
			message.setRegistryUrl(registryUrl);
			message.setKind(Constants.MQ_ROUTEKEY_TAG);
			message.setProject(project);
			message.setRegion(MDC.get(MDCConstants.REGION_ID));
			mQMessageService.sendMqMessage(message);
		}

		return ret == 1;
	}

	@Override
	public boolean deleteTag(TokenDO token, List<String> ids, String imageId, String project) {
		
		RegionDTO regionDTO = regionMapper.selectByPrimaryKey(MDC.get(MDCConstants.REGION_ID));
		if(regionDTO==null) {
			throw new ParamInvalidException("the current region does not exist in db!");
		}
		
		if (ids == null || ids.size() == 0) {
			return true;
		}

		List<TagDTO> tags = queryTagListWithMarded(imageId);
		if (tags != null && tags.size() > 0) {
			throw new ParamInvalidException(MessageUtils.getMessage("tag.delete.marked"));
		}

		String id = ids.get(0);
		TagDTOExample example = new TagDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andUuidEqualTo(id);

		List<TagDTO> tagList = tagMapper.selectByExample(example);
		if (tagList == null || tagList.size() == 0) {
			throw new ParamInvalidException(MessageUtils.getMessage("tag.delete.is.not.exist"));
		}
		TagDTO tagDTO = tagList.get(0);

		ImageDTO image = imageService.queryImageById(imageId);
		String imageName = image.getName();
		String param = imageName + ":" + tagDTO.getName();
		String headUrl = "";
		if (Constants.REGISTRY_TYPE_PLATFORM.equals(image.getRegistryType())) {
			ProjectDTO projectDTO = projectService.queryProjectById(image.getProjectId());
			param = projectDTO.getName() + ":" + param;
			headUrl = ClientConstants.URL_HTTPS + token.getUserName() + ":" + token.getTokenId() + "@"
					+ ClientConstants.OPENSHIFT_REGISTRY_URL;
		} else if (Constants.REGISTRY_TYPE_THIRD.equals(image.getRegistryType())) {
			RegistryDTO registry = registryService.queryRegistryById(image.getRegistryId());
			String[] urlArr = registry.getUrl().split("//");
			headUrl = urlArr[0] + "//" + registry.getUserName() + ":" + registry.getPassword() + "@" + urlArr[1];
		} else if (Constants.REGISTRY_TYPE_PRIVATE.equals(image.getRegistryType())) {
			RegistryDTO registry = registryService.queryRegistryById(image.getRegistryId());
			headUrl = registry.getUrl();
		}
		try {
			log.info("===============send request to openshift========================");
			Invocation<TagDTO> invocation = delete(TagDTO.class, "/tools/docker/images/" + param, null)
					.endpoint(regionDTO.getContainerUrl()).header(ClientConstants.CONTENT_TYPE, ClientConstants.CONTENT_TYPE_JSON)
					.header(ClientConstants.REGISTRY_URL, headUrl);
			invocation.executeWithResponse();
		} catch (ResourcesNotFoundException e) {
			// log
			e.printStackTrace();
		}
		if(image.getMarkFlag() == null || image.getMarkFlag() != 1) {
			image.setMarkFlag(1);
			imageService.editImage(image);
		}
		tagDTO.setMarkFlag(1);
		
		tagMapper.updateByPrimaryKeySelective(tagDTO);
		return true;
	}

	@Override
	public List<TagDTO> queryTagList(String imageId) {

		TagDTOExample example = new TagDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andImageIdEqualTo(imageId);
//		criteria.andMarkFlagNotEqualTo(1);
		example.setOrderByClause("created_time desc");
		return tagMapper.selectByExample(example);
	}
	
	@Override
	public boolean editTag(TokenDO token, TagRequestData requestData, String tagId) {

		TagDTO tagDTO = new TagDTO();
		tagDTO.setUuid(tagId);
		tagDTO.setChangelog(requestData.getChangelog());

		return 1 == tagMapper.updateByPrimaryKeySelective(tagDTO);
	}

	@Override
	public TagDTO queryTagDetailById(String tagId) {
		TagDTO tag = tagMapper.selectByPrimaryKey(tagId);
		List<LayerDTO> layerList = layerService.queryLayerListByTagId(tag.getUuid());
		tag.setLayers(layerList);
		return tag;
	}
	
	@Override
	public int deleteTagByRegistryId(String registryId) {
		
		return tagMapper.deleteTagByRegistryId(registryId);
	}
	
	public long countByNameAndImageId(String name, String imageId) {
		TagDTOExample example = new TagDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andImageIdEqualTo(imageId);
		return tagMapper.countByExample(example);
	}
	
	public List<TagDTO> queryTagListWithMarded(String imageId) {

		TagDTOExample example = new TagDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andImageIdEqualTo(imageId);
		criteria.andMarkFlagEqualTo(1);
		return tagMapper.selectByExample(example);
	}
	
}
