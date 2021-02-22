package com.mpc.config;

import java.util.Collections;

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
	
		  @Bean
		  public Docket api() { 
		        
		        		return new Docket(DocumentationType.SWAGGER_2)  
		        		          .select()                                  
		        		          .apis(RequestHandlerSelectors.basePackage("com.mpc"))           
		        		          .paths(PathSelectors.any())                          
		        		          .build();                                           
		    }
		  
		  private ApiInfo metaDato() {
			ApiInfo apiInfo = new ApiInfo(
					"API Verificacion Mutantes",
					"Spring Boot API Mutantes", 
					"1.0", 
					"Terminos del Servicio", 
					new Contact("Diego Castaneda", "http://dics/Mutant", "idiegocs@gmail.com"), 
					"DICS", 
					"https://dics.com",
					Collections.emptyList()
			);
			return apiInfo;
		}

}


