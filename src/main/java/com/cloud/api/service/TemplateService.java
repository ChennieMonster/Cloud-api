/**
 * 
 */
package com.cloud.api.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.cloud.api.dto.TemplateDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TemplateDetailDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.TemplateRequest;

/**
 * @author zhao_pengchen
 *
 */
public interface TemplateService {

	String addTemplate(TemplateRequest requestData, TokenDO token,String regionId, String project);
	
	TemplateDetailDO getTemplateDetail(String uuid);
	
	boolean deleteTemplates(TokenDO token, List<String> ids,String regionId, String project);

	TemplateDTO queryTemplateByUuid(String uuid);
	
	List<TemplateDTO> queryTemplateList(String type);

	void editTemplate(TokenDO token, TemplateRequest requestData, String uuid, String project);
	
	long countTemplate();
	
	List<TemplateDTO> filterTemplate(List<GetListParamElement> filterList,String regionId, String project);
	
	List<TemplateDTO> filterTemplateAndType(List<GetListParamElement> filterList,String type,String regionId, String project);
	
	TemplateDetailDO getTemplateDetailByName(String project,String name);
	
	void uploadTemplate(TemplateRequest requestData, TokenDO token,String regionId, String project);

	void exportTemplate(TemplateRequest data, TokenDO token,HttpServletResponse response);
	
}
