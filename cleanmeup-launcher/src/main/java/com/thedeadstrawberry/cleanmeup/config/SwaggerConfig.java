package com.thedeadstrawberry.cleanmeup.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${spring.application.name:}")
	private String projectName;

	@Value("${spring.application.version:}")
	private String projectVersion;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				  .select()
				  .apis(RequestHandlerSelectors.basePackage("com.thedeadstrawberry.cleanmeup.controllers"))
				  .paths(PathSelectors.any())
				  .build()
				  .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		Contact contactInfo = new Contact("The Dead Strawberry",
				  "https://github.com/thedeadstrawberry/cleanmeup",
				  "thedeadstrawberry@gmail.com");

		return new ApiInfo(projectName, "", projectVersion, "Terms of Service", contactInfo, null, null);
	}
}
