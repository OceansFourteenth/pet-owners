/**
 * Created Sep 28, 2020 by brain
 */
package com.oceansfourteenth.pet_owners.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.Data;

/**
 * @author OceansFourteenth
 *
 */
@Data
public class Owner {
	
	public static final List<Owner> owners = new ArrayList<>();
	
	@Positive
	private long id;
	
	/**
	 * Owner's name
	 */
	@NotEmpty
	private String name;
	
	private List<Pet> pets;
	
	public Owner() {
		super();
		owners.add(this);
		this.setId(owners.size());
	}
	
	public List<Pet> getPets() {
		if (pets == null) {
			pets = new ArrayList<>();
		}
		
		return pets;
	}
	
}
