/**
 * Created Sep 28, 2020 by brain
 */
package com.oceansfourteenth.petowners.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.oceansfourteenth.petowners.extensions.swagger.ApiModelPropertyDescription;

import lombok.Data;

/**
 * A pet belonging to an owner.
 * 
 * @author OceansFourteenth
 *
 */
@Data
public class Pet {
	/**
	 * The pet's name
	 */
	@NotNull
	@NotEmpty
	@ApiModelPropertyDescription("The pet's name.")
	private String name;

	/**
	 * The type of animal
	 */
	@NotNull
	@ApiModelPropertyDescription("The type of animal.")
	private PetType type;

	public Pet(Owner owner) {
		super();
		owner.getPets().add(this);
	}
}
