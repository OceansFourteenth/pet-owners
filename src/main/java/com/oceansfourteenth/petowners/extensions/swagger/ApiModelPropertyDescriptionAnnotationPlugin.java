/**
 * 
 */
package com.oceansfourteenth.petowners.extensions.swagger;

import java.util.Optional;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import springfox.bean.validators.plugins.Validators;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

/**
 * Adds descriptions to properties annotated with
 * {@link ApiModelPropertyDescription}
 * 
 * @author OceansFourteenth
 *
 */
@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
public class ApiModelPropertyDescriptionAnnotationPlugin implements ModelPropertyBuilderPlugin {

	@Override
	public boolean supports(DocumentationType delimiter) {
		return SwaggerPluginSupport.pluginDoesApply(delimiter);
	}

	@Override
	public void apply(ModelPropertyContext context) {
		Optional<ApiModelPropertyDescription> description = Validators.annotationFromBean(context,
				ApiModelPropertyDescription.class);
		if (description.isPresent()) {
			context.getSpecificationBuilder().description(description.get().value());
		}
	}

}
