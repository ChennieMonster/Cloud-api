/**
 * 
 */
package com.cloud.api.mapper;

import java.util.List;

import com.cloud.api.dto.TemplateDTO;
import com.cloud.api.dto.TemplateDTOExample;

/**
 * @author zhao_pengchen
 *
 */
public interface TemplateMapper {

	/**
	 * 根据用户ID查询权限内的相关template
	 */
	List<TemplateDTO> queryTemplateList(String type);

	/**
	 * 新增template
	 * 
	 * @param templateDTO
	 * @return
	 */
	int insertTemplate(TemplateDTO templateDTO);

	/**
	 * 删除template
	 */
	int deleteTemplate(String uuid);

	/**
	 * 批量删除template
	 */
	int deleteTemplates(List<String> ids);

	/**
	 * 编辑template
	 */
	int updateTemplateById(TemplateDTO templateDTO);

	/**
	 * 根据uuid查Template详细
	 * 
	 * @param uuid
	 * @return
	 */
	TemplateDTO queryTemplateByUuid(String uuid);
	
	/**
	 * 根据名字查询template
	 * @param name
	 * @return
	 */
	TemplateDTO queryTemplateByName(String project,String name);
	
	long countByExample(TemplateDTOExample example);

	List<TemplateDTO> selectByExample(TemplateDTOExample example);
}
