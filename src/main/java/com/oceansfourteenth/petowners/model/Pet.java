/**
 * Created Sep 28, 2020 by brain
 */
package com.oceansfourteenth.pet_owners.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author OceansFourteenth
 *
 */
@Data
@NoArgsConstructor
public class Pet {
	/**
	 * The pet's name
	 */
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
