package com.oceansfourteenth.pet_owners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oceansfourteenth.pet_owners.model.Owner;
import com.oceansfourteenth.pet_owners.model.Pet;
import com.oceansfourteenth.pet_owners.model.PetType;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		Owner owner = new Owner();
		owner.setName("Ali");
		
		Pet pet = new Pet(owner);
		pet.setName("pet");
		pet.setType(PetType.BIRD);
		
		log.info("Owner: {}", owner);
		log.info("Pets: {}", owner.getPets());
	}

}
