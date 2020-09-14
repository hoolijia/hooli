package com.hooli.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/14 4:41 下午
 * @description：客户端接口文档
 */
@Configuration
@EnableSwagger2
public class WebSwaggerConfig {

    @Bean
    public Docket webDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("web")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hooli.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("客户端接口文档")
                .description("客户端接口文档")
                .termsOfServiceUrl("https://qq.com")
                .version("1.0.0")
                .build();
    }
}
