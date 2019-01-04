package com.cloud.api.core.config;

import static com.cloud.api.core.constant.ProjectConstant.CONTROLLER_PACKAGE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 在线API文档
 * http://springfox.github.io/springfox/docs/current/#getting-started
 *
 * @author Zoctan
 * @date 2018/05/27
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket buildDocket() {
    	
    	List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("Not Found").build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("Unauthorized").build());
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("Bad Request").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("Internal Server Error").build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("Forbidden").build());
    	
        return new Docket(DocumentationType.SWAGGER_2)
        		.globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(this.buildApiInfo())
                .select()
                // 扫描 controller 包
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo() {
        final Contact contact = new Contact(
                "Zoctan",
                "https://github.com/Zoctan",
                "752481828@qq.com"
        );

        return new ApiInfoBuilder()
                .title("APIs doc")
                .description("RESTFul APIs")
                .termsOfServiceUrl("https://github.com/Zoctan/spring-boot-api-seedling")
                .contact(contact)
                .version("1.0")
                .license("Apache License 2.0")
                .licenseUrl("https://github.com/Zoctan/spring-boot-api-seedling/blob/master/LICENSE")
                .build();
    }
}
