package com.cloud.api.core.response;

import com.cloud.api.util.JsonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhang.feng
 * @date 2018/09/15
 */
@ApiModel(value = "响应结果")
public class Result<T> {
	@ApiModelProperty(value = "状态码")
	private Integer code;

	@ApiModelProperty(value = "总数")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long allCount;

	@ApiModelProperty(value = "过滤数")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long filterCount;

	@ApiModelProperty(value = "消息")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;

	@ApiModelProperty(value = "是否完全成功")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean success;

	@ApiModelProperty(value = "数据")
	private T data;

	@Override
	public String toString() {
		return JsonUtils.objectToJson(this).toString();
	}

	public Result<T> setCode(final Integer code) {
		this.code = code;
		return this;
	}

	/**
	 * @return the allCount
	 */
	public Long getAllCount() {
		return allCount;
	}

	/**
	 * @param allCount the allCount to set
	 */
	public Result<T> setAllCount(long allCount) {
		this.allCount = allCount;
		return this;
	}

	/**
	 * @return the filterCount
	 */
	public Long getFilterCount() {
		return filterCount;
	}

	/**
	 * @param filterCount the filterCount to set
	 */
	public Result<T> setFilterCount(long filterCount) {
		this.filterCount = filterCount;
		return this;
	}

	public Result<T> setMessage(final String message) {
		this.message = message;
		return this;
	}

	public Result<T> setData(final T data) {
		this.data = data;
		return this;
	}

	public Result<T> setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public T getData() {
		return this.data;
	}

	public boolean isSuccess() {
		return success;
	}

}
