package com.cloud.api.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 上下文工具
 *
 * @author Zoctan
 * @date 2018/07/20
 */
public class ContextUtils {
	
	 private static ApplicationContext applicationContext;
	 
    private ContextUtils() {

    }

    /**
     * 获取 request
     *
     * @return request
     */
    public static HttpServletRequest getRequest() {
        final ServletRequestAttributes attributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        return attributes == null ? null : attributes.getRequest();
    }
    
    public static void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        applicationContext = ac;
    }
    
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    
    public static <T> List<T> getBeanByType(Class<T> clazz) {
        List<T> list = new ArrayList<T>();

        /* 获取接口的所有实例名 */
        String[] beanNames = applicationContext.getBeanNamesForType(clazz);

        if (beanNames == null || beanNames.length == 0) {
            return list;
        }

        T t = null;
        for (String beanName : beanNames) {
            t = (T)applicationContext.getBean(beanName);
            list.add(t);
        }

        return list;
    }

}
