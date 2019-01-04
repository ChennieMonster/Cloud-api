/**
 * 
 */
package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.ImageDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.request.ImageRequestData;

/**
 * @author zhao_pengchen
 *
 */
public interface ImageService {
	
	/**
	 * 创建image
	 * @param token
	 * @param imageDTO
	 * @return
	 */
	ImageDTO addImage(ImageRequestData requestData, String registryId,String project,String regionId);
	
	/**
	 * 删除image
	 * @param token
	 * @param imageID
	 * @return
	 */
	boolean deleteImage(List<String> ids);
	
	/**
	 *查询所有image
	 * @param type
	 * @return
	 */
	List<ImageDTO> queryImageList(String registryId);
	
	/**
	 * 修改image
	 * @param token
	 * @param imageDTO
	 * @return
	 */
	boolean editImage(ImageRequestData requestData,String imageID);
	
	/**
	 * 修改image
	 * @param imageDTO
	 * @return
	 */
	int editImage(ImageDTO imageDTO);
	
	/**
	 * 查询单个registry下的image数量
	 * @param registryId
	 * @return
	 */
	int queryCountByRegistryId(String registryId);
	
	/**
	 * 根据uuid查询image
	 * @param registryId
	 * @return
	 */
	ImageDTO queryImageById(String uuid);
	
	/**
	 * 查询所有image的数量
	 * @return
	 */
	long countImage();
	
	/**
	 * image分页
	 * @param filterList
	 * @param registryId
	 * @return
	 */
	List<ImageDTO> filterImage(List<GetListParamElement>  filterList,String registryId);
	
	/**
	 * 根据registryId删除image
	 * @param registryId
	 * @return
	 */
	int deleteImageByRegistryId(String registryId);
}
