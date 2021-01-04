/**
 * 
 */
package com.oceansfourteenth.petowners.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author OceansFourteenth
 *
 */
@Configuration
@EnableMongoRepositories("com.oceansfourteenth.petowners.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Override
	protected String getDatabaseName() {
		return "pet-owners";
	}

}
