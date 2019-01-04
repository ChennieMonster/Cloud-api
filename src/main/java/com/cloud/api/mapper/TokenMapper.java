/**
 * 
 */
package com.cloud.api.mapper;

import java.util.ArrayList;
import java.util.Map;

import com.cloud.api.entity.TokenDO;

/**
 * @author zhang.feng
 *
 */
public interface TokenMapper {

	/**
	 * 根据用户名查询token
	 * 
	 * @param userName
	 * @return
	 */

	ArrayList<TokenDO> queryToken(Map<String, String> paramMap);

	/**
	 * 新增token
	 * 
	 * @param tokenDO
	 * @return
	 */
	int insertToken(TokenDO tokenDO);

	/**
	 * 删除token
	 */

	int deleteToken(String userName);

}
