/**
 * Created Sep 29, 2020 by brain
 */
package com.oceansfourteenth.petowners.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.oceansfourteenth.petowners.model.Owner;
import com.oceansfourteenth.petowners.service.api.IOwnerService;

import lombok.extern.log4j.Log4j2;

/**
 * @author OceansFourteenth
 *
 */
@Log4j2
@RestController
@RequestMapping("/owners")
public class OwnerController {

	@Autowired
	private IOwnerService ownerService;

	@GetMapping
	public List<Owner> getOwners() {
		log.info("GET all owners");
		return ownerService.getOwners().orElse(Collections.emptyList());
	}

	@PostMapping
	public Owner createOwner(@RequestBody @Valid Owner newOwner) {
		log.info("POST new owner: {}", newOwner);
		try {
			return ownerService.createOwner(newOwner)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Owner", e);
		}
	}

	@PostMapping("{name}")
	public Owner createOwner(@PathVariable("name") String name) {
		log.info("POST new owner by name: {}", name);
		try {
			return ownerService.createOwner(name)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Name", e);
		}
	}

	@GetMapping("{id}")
	public Owner getOwnerById(@PathVariable("id") @NotNull @PositiveOrZero long id) {
		log.info("GET owner by id: {}", id);
		return ownerService.getOwner(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found with given id"));
	}
}
