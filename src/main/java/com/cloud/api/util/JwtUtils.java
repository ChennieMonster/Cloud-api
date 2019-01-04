package com.cloud.api.util;

import org.springframework.util.StringUtils;

/**
 * @author zhang.feng
 * @date 2018/9/29
 */
public class JwtUtils {
    private static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";

    /**
     * remove 'Bearer ' string
     *
     * @param authorizationHeader
     * @return
     */
    public static String getRawToken(String authorizationHeader) {
        return authorizationHeader.substring(AUTHORIZATION_HEADER_PREFIX.length());
    }

    public static String getTokenHeader(String rawToken) {
        return AUTHORIZATION_HEADER_PREFIX + rawToken;
    }

    public static boolean validate(String authorizationHeader) {
        return StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith(AUTHORIZATION_HEADER_PREFIX);
    }

    public static String getAuthorizationHeaderPrefix() {
        return AUTHORIZATION_HEADER_PREFIX;
    }
}