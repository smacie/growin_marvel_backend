package com.growin.marvel.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class
Swagger2Config {

    private final Environment environment;

    @Autowired
    public Swagger2Config(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(environment.getProperty("swagger.package")))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title(environment.getProperty("swagger.title"))
                .description(environment.getProperty("swagger.description"))
                .contact(new Contact(environment.getProperty("swagger.name"), environment.getProperty("swagger.site") , environment.getProperty("swagger.email")))
                .license(environment.getProperty("swagger.license"))
                .licenseUrl(environment.getProperty("swagger.licenseUrl"))
                .version(environment.getProperty("swagger.version"))
                .build();
    }
}
