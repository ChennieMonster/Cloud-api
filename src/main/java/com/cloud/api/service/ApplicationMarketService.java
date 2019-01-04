/**
 * 
 */
package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.ApplicationMarketDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.AddMarketRequest;
import com.cloud.api.entity.request.DeployAppFromMarketReq;
import com.cloud.api.entity.response.EditMarketResponse;
import com.cloud.api.entity.response.OpenAppPageResponse;

/**
 * @author zhao_pengchen
 *
 */
public interface ApplicationMarketService {

	List<ApplicationMarketDTO> getApplicationMarkets(List<GetListParamElement> filterList, String project);
	
	ApplicationMarketDTO getApplicationMarket(String uuid);
	
	List<OpenAppPageResponse> openAppPage(String uuid);
	
	void deployApp(DeployAppFromMarketReq request, TokenDO token,String regionId , String project);
	
	void addMarket(AddMarketRequest request, TokenDO token,String regionId, String project);
	
	void deleteMarket(String uuid, TokenDO token,String regionId, String project);
	
	void updateMarket(AddMarketRequest request, TokenDO token, String project);
	
	EditMarketResponse openEditPage(String uuid);
	
}
