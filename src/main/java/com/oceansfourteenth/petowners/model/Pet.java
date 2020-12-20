/**
 * Created Sep 28, 2020 by brain
 */
package com.oceansfourteenth.petowners.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
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
	private String name;

	/**
	 * The type of animal
	 */
	@NotNull
	private PetType type;

	public Pet(Owner owner) {
		super();
		owner.getPets().add(this);
	}
}
