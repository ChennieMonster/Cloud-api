/**
 * 
 */
package com.cloud.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.ImageDTO;
import com.cloud.api.dto.ImageDTOExample;
import com.cloud.api.dto.ImageDTOExample.Criteria;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.RegistryDTO;
import com.cloud.api.dto.TagDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.request.ImageRequestData;
import com.cloud.api.mapper.ImageMapper;
import com.cloud.api.service.ImageService;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.RegistryService;
import com.cloud.api.service.TagService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.MessageUtils;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional
public class ImageServiceImpl extends BaseService implements ImageService {
	
//	private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

	@Resource
	private ImageMapper imageMapper;
	
	@Resource
	private TagService tagService;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private RegistryService registryService;
	
	@Value("${platform.registry.url}")
	private String platformUrl;
	
	@Value("${platform.project}")
	private String platformProject;
	
	@Override
	public ImageDTO addImage(ImageRequestData requestData,String registryId,String project,String regionId) {
		if(countImageByNameAndRegistryId(requestData.getImageName(),registryId) > 0) {
			throw new ParamInvalidException(MessageUtils.getMessage("image.name.already.exists"));
		}
		RegistryDTO registry = registryService.queryRegistryById(registryId);
		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setUuid(IdGen.uuid());
		imageDTO.setDescription(requestData.getImageDescription());
		imageDTO.setDisplayName(requestData.getImageDisplayName());
		imageDTO.setName(requestData.getImageName());
		imageDTO.setIcon(requestData.getImageIcon());
		imageDTO.setRegistryType(requestData.getImageType());
		imageDTO.setRegistryId(registryId);
		
		if(Constants.REGISTRY_TYPE_PLATFORM.equalsIgnoreCase(requestData.getImageType())) {
			ProjectDTO projectDTO = projectService.queryProjectByRegionIdAndProjectName(regionId,platformProject);
			imageDTO.setProjectId(projectDTO.getUuid());
			imageDTO.setUrl(platformUrl + "/" + platformProject);
		}else{
			ProjectDTO projectDTO = projectService.queryProjectByRegionIdAndProjectName(regionId,platformProject);
			imageDTO.setProjectId(projectDTO.getUuid());
			imageDTO.setUrl(registry.getUrl().replaceFirst("https://", ""));
		}
		
		if(1 == imageMapper.insertSelective(imageDTO)) {
			return imageDTO;
		}
		return null;
	}

	@Override
	public boolean deleteImage(List<String> ids) {
		for (String imageId : ids) {
			List<TagDTO> tagList = tagService.queryTagList(imageId);
			if(tagList.size() > 0) {
				throw new ParamInvalidException("some images have tag,can not delete!");
			}
		}
		ImageDTOExample example = new ImageDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andUuidIn(ids);
		return 1 == imageMapper.deleteByExample(example);
	}

	@Override
	public List<ImageDTO> queryImageList(String registryId) {
		
		ImageDTOExample example = new ImageDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andRegistryIdEqualTo(registryId);
		example.setOrderByClause("created_time desc");
		List<ImageDTO> list = imageMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean editImage(ImageRequestData requestData,String imageID) {
		
		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setDescription(requestData.getImageDescription());
		imageDTO.setDisplayName(requestData.getImageDisplayName());
		imageDTO.setName(requestData.getImageName());
		imageDTO.setIcon(requestData.getImageIcon());
		imageDTO.setUpdatedTime(new Date());
		imageDTO.setUuid(imageID);
		
		return 1 == imageMapper.updateByPrimaryKeySelective(imageDTO);
	}

	@Override
	public int queryCountByRegistryId(String registryId) {
		ImageDTOExample example = new ImageDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andRegistryIdEqualTo(registryId);
		return (int) imageMapper.countByExample(example);
	}

	@Override
	public ImageDTO queryImageById(String uuid) {
		
		return imageMapper.selectByPrimaryKey(uuid);
	}

	@Override
	public long countImage() {
		
		ImageDTOExample example =new ImageDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.getAllCriteria();
		return imageMapper.countByExample(example);
	}

	@Override
	public List<ImageDTO> filterImage(List<GetListParamElement> filterList, String registryId) {
		// TODO Auto-generated method stub
		ImageDTOExample example =new ImageDTOExample();
		Criteria criteria =example.createCriteria();
		if(filterList != null && !filterList.isEmpty()) {
			if(registryId!=null&&registryId=="") {
				criteria.andRegistryIdEqualTo(registryId);
				for(int i = 0 ; i<filterList.size() ; i++) {
					String key =filterList.get(i).getKey();
					if(key.equals(Constants.FILTER_NAME_DISPLAYNAME)) {
						String value=filterList.get(i).getValue();
						criteria.andDisplayNameLike("%"+value+"%");
					}
				}
			}else {
				for(int i = 0 ; i<filterList.size() ; i++) {
					String key =filterList.get(i).getKey();
					if(key.equals(Constants.FILTER_NAME_DISPLAYNAME)) {
						String value=filterList.get(i).getValue();
						criteria.andDisplayNameLike("%"+value+"%");
					}
				}
			}
			
		}else {
			criteria.andRegistryIdEqualTo(registryId);
		}
		example.setOrderByClause("created_time desc");
		return imageMapper.selectByExample(example);
	}
	
	@Override
	public int deleteImageByRegistryId(String registryId) {
		ImageDTOExample example =new ImageDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.andRegistryIdEqualTo(registryId);
		return imageMapper.deleteByExample(example);
	}
	
	public long countImageByNameAndRegistryId(String name,String registryId) {
		ImageDTOExample example =new ImageDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andRegistryIdEqualTo(registryId);
		return imageMapper.countByExample(example);
	}

	@Override
	public int editImage(ImageDTO imageDTO) {
		return imageMapper.updateByPrimaryKeySelective(imageDTO);
	}
	
	
}
