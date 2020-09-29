/**
 * Created Sep 28, 2020 by brain
 */
package com.oceansfourteenth.pet_owners.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author OceansFourteenth
 *
 */
@Data
public class Owner {
	
	/**
	 * Owner's name
	 */
	@NotEmpty
	private String name;
	
	private List<Pet> pets;
	
	public List<Pet> getPets() {
		if (pets == null) {
			pets = new ArrayList<>();
		}
		
		return pets;
	}
	
}
