/**
 * 
 */
package com.oceansfourteenth.petowners.service.impl.mongodb;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oceansfourteenth.petowners.model.Owner;
import com.oceansfourteenth.petowners.repository.mongodb.OwnerMongoRepository;
import com.oceansfourteenth.petowners.service.api.IOwnerService;

/**
 * @author OceansFourteenth
 *
 */
@Service("ownerService")
public class OwnerServiceMongoRepositoryImpl implements IOwnerService {
	
	@Autowired
	private OwnerMongoRepository repository;

	@Override
	public Optional<List<Owner>> getOwners() {
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public Optional<Owner> getOwner(long id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Owner> createOwner(@NotEmpty String name) throws IllegalArgumentException {
		Owner owner = new Owner();
		owner.setName(name);
		return createOwner(owner);
	}

	@Override
	public Optional<Owner> createOwner(@Valid Owner newOwner) throws IllegalArgumentException {
		newOwner.setId(repository.count() + 1);
		return Optional.ofNullable(repository.save(newOwner));
	}

}
