/**
 * Created Sep 28, 2020
 *
 * Licensed at https://github.com/OceansFourteenth/pet-owners.git/LICENSE.md
 */
package com.oceansfourteenth.petowners.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.stereotype.Component;

import com.oceansfourteenth.petowners.extensions.swagger.ApiModelPropertyDescription;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author OceansFourteenth
 *
 */
@Data
@Component
@ApiModel(description = "The base object. Represents a pet owner.")
public class Owner {

	@PositiveOrZero
	@NotNull
	@ApiModelPropertyDescription("The owner's unique identifier.")
	private long id;

	/**
	 * Owner's name
	 */
	@NotEmpty
	@NotNull
	@ApiModelPropertyDescription("The owner's name")
	private String name;

	@Valid
	@NotNull
	@ApiModelPropertyDescription("A list of the owners pets")
	private List<Pet> pets;

	public Owner() {
		super();
		pets = new ArrayList<>();
	}
}
