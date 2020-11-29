/**
 * Created Sep 28, 2020 by brain
 */
package com.oceansfourteenth.petowners.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author OceansFourteenth
 *
 */
@Data
@Component
public class Owner {

	@PositiveOrZero
	private long id;

	/**
	 * Owner's name
	 */
	@NotEmpty
	private String name;

	@NotNull
	private List<Pet> pets;

	public Owner() {
		super();
		pets = new ArrayList<>();
	}
}
