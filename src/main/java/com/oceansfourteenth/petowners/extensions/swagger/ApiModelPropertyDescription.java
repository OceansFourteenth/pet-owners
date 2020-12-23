/**
 * 
 */
package com.oceansfourteenth.petowners.extensions.swagger;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Defines a description for a property in Swagger/OpenApi spec
 * 
 * @author OceansFourteenth
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface ApiModelPropertyDescription {

	/**
	 * The description
	 */
	String value();
}
