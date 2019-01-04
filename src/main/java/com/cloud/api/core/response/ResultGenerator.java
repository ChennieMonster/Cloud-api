package com.cloud.api.core.response;

import org.springframework.http.HttpStatus;

/**
 * 响应结果生成工具
 *
 * @author zhang_feng
 * @date 2018/10/15
 */
public class ResultGenerator {
	/**
	 * 成功响应结果
	 *
	 * @param data 内容
	 * @return 响应结果
	 */
	public static <T> Result<T> genGetOkResult(final T data) {
		return new Result<T>().setCode(HttpStatus.OK.value()).setSuccess(true).setData(data);
	}

	/**
	 * 成功响应结果
	 *
	 * @param data 内容
	 * @return 响应结果
	 */
	public static <T> Result<T> genListOkResult(long allCount, long filterCount, final T data) {
		return new Result<T>().setCode(HttpStatus.OK.value()).setSuccess(true).setAllCount(allCount).setFilterCount(filterCount)
				.setData(data);
	}

	/**
	 * 成功响应结果
	 *
	 * @return 响应结果
	 */
	public static <T> Result<T> genOkResult() {
		return new Result<T>().setCode(HttpStatus.OK.value()).setSuccess(true);
	}

	/**
	 * 失败响应结果
	 * 
	 * @param code    状态码
	 * @param message 消息
	 * @return 响应结果
	 */
	public static Result<?> genFailedResult(final int code, final String message) {
		return new Result().setCode(code).setSuccess(false).setMessage(message);
	}

	/**
	 * 失败响应结果
	 *
	 * @param message 消息
	 * @return 响应结果
	 */
	public static Result<?> genFailedResult(final String message) {
		return genFailedResult(ResultCode.SUCCEED_REQUEST_FAILED_RESULT.getValue(), message);
	}
    
    /**
     * 失败响应结果
     *
     * @param resultCode 状态码枚举
     * @return 响应结果
     */
    public static Result<?> genFailedResult(final ResultCode resultCode, String message) {
        return genFailedResult(resultCode.getValue(), message);
    }

	/**
	 * 失败响应结果
	 *
	 * @param resultCode 状态码枚举
	 * @return 响应结果
	 */
	public static Result<?> genFailedResult(final ResultCode resultCode) {
		return genFailedResult(resultCode.getValue(), resultCode.getReason());
	}

	/**
	 * 失败响应结果
	 *
	 * @return 响应结果
	 */
	public static Result<?> genFailedResult() {
		return genFailedResult(ResultCode.SUCCEED_REQUEST_FAILED_RESULT);
	}
}
