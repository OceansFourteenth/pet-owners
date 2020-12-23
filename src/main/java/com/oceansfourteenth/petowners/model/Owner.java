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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "The owner's unique identifier.", required = true)
	private long id;

	/**
	 * Owner's name
	 */
	@NotEmpty
	@NotNull
	@ApiModelProperty(value = "The owner's name.", required = true)
	private String name;

	@Valid
	@NotNull
//	@ApiModelProperty("A list of the owner's pets.")
	private List<Pet> pets;

	public Owner() {
		super();
		pets = new ArrayList<>();
	}
}
