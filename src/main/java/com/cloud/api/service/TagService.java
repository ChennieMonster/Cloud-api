package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.TagDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.TagRequestData;


/**
* @author huang_kefei
* @date 2018年9月30日
* 类说明
*/
public interface TagService {
	
	/**
	 * 创建Tag
	 * @param token
	 * @param requestData
	 * @return
	 */
	boolean addTag(TokenDO token, TagRequestData requestData,String imageId,String project);
	
	/**
	 * 删除Tag
	 * @param token
	 * @param tagName
	 * @return
	 */
	boolean deleteTag(TokenDO token, List<String> ids, String imageId, String project);
	
	/**
	 * 查询Tag
	 * @param imageId
	 * @return
	 */
	List<TagDTO> queryTagList(String imageId);
	
	/**
	 * 修改Tag
	 * @param token
	 * @param requestData
	 * @return
	 */
	boolean editTag(TokenDO token, TagRequestData requestData, String tagId);
	
	/**
	 * 查询tag详细
	 * @param tagId
	 * @return
	 */
	TagDTO queryTagDetailById(String tagId);
	
	/**
	 * 根据registryId删除tag
	 * @param registryId
	 * @return
	 */
	int deleteTagByRegistryId(String registryId);
}
