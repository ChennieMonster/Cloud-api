package com.cloud.api.service;

import com.cloud.api.entity.TokenDO;

public interface AuthOpenShiftService {

	public TokenDO getOpenShiftToken(String userName) throws Exception;

	public boolean authUser(String userName, String passwd);
}
