/**
 * Created Sep 28, 2020 by brain
 */
package com.oceansfourteenth.petowners.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
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
	@NotNull
	private long id;

	/**
	 * Owner's name
	 */
	@NotEmpty
	@NotNull
	private String name;

	@Valid
	private List<Pet> pets;

	public Owner() {
		super();
		pets = new ArrayList<>();
	}
}
