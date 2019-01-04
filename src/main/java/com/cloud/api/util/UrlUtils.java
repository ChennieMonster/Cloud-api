package com.cloud.api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * URL工具
 *
 * @author zhang.feng
 * @date 2018/09/25
 */
public class UrlUtils {
			
    private UrlUtils() {

    }

    /**
     * 请求的相对路径 /user/list
     *
     * @param request request
     * @return 相对路径
     */
    public static String getMappingUrl(final ServletRequest request) {
        return getMappingUrl((HttpServletRequest) request);
    }

    public static String getMappingUrl(final HttpServletRequest request) {
        return request.getRequestURI().substring(request.getContextPath().length());
    }
    
	/**
	 * 获取指定URL中的某个参数
	 * 
	 * @param url
	 * @param name
	 * @return
	 */
    public static String getParamByUrl(String url, String name) {
		url += "&";
		String pattern = name + "=\\S*?(&{1})";

		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(url);
		if (m.find()) {
			return m.group(0).split("=")[1].replace("&", "");
		} else {
			return null;
		}
	}
}
