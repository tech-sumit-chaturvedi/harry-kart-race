package se.atg.service.harrykart;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(

				new ApiInfo("HARRY-KART-API", "This API can be used to get top 3 Rank information in HarryKart race.", "v1.0", "https://www.atg.se/hjalp/regler-och-villkor",
						new Contact("support", "https://www.swedishhorseracing.com/", "kundservice@atg.se"), null, null,
						new ArrayList()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("se.atg.service.harrykart"))
				.paths(Predicates.not(PathSelectors.regex("(/manage.*|/error|/actuator)")))
				.build();
	}
}
