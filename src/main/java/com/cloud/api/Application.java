package com.cloud.api;

import static com.cloud.api.core.constant.ProjectConstant.MAPPER_PACKAGE;


import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cloud.api.util.ContextUtils;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 主程序
 *
 * @author Zoctan
 * @date 2018/05/27
 */
@EnableCaching
@ServletComponentScan
@EnableEncryptableProperties
@EnableTransactionManagement
@MapperScan(basePackages = MAPPER_PACKAGE)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,SecurityAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {

    /**
     * 容器启动配置
     */
    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

    public static void main(final String[] args) {
    	
		ApplicationContext app = SpringApplication.run(Application.class, args);

		ContextUtils.setApplicationContext(app);
    }


}