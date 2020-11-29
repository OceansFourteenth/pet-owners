/**
 * Created Sep 29, 2020 by brain
 */
package com.oceansfourteenth.pet_owners.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oceansfourteenth.pet_owners.model.Owner;

import lombok.extern.log4j.Log4j2;

/**
 * @author OceansFourteenth
 *
 */
@Log4j2
@RestController
@RequestMapping("/owners")
public class OwnerController {
	
	@GetMapping
	public List<Owner> getOwners() {
		log.info("GET all owners");
		return Owner.owners;
	}
}
