/**
 * Created Dec 20, 2020
 *
 * Licensed at https://github.com/OceansFourteenth/pet-owners.git/LICENSE.md
 */
package com.oceansfourteenth.petowners.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author OceansFourteenth
 *
 */
@Configuration
public class SpringfoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}
