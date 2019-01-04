package com.cloud.api.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author zhang_feng
 *
 */
public class TokenDO {

	/**
	 * uuid
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String uuid;
	
	/**
	 * token
	 */
	private String tokenId;
	
	/**
	 * 过期时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date expiresTime;
	
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createTime;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * token的类型
	 */
	private String type;
	
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * @return the tokenId
	 */
	public String getTokenId() {
		return tokenId;
	}
	/**
	 * @param tokenId the tokenId to set
	 */
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	/**
	 * @return the expiresTime
	 */
	public Date getExpiresTime() {
		return expiresTime;
	}
	/**
	 * @param expiresTime the expiresTime to set
	 */
	public void setExpiresTime(Date expiresTime) {
		this.expiresTime = expiresTime;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
