/**
 * 
 */
package com.oceansfourteenth.petowners.service.impl.mongodb;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.oceansfourteenth.petowners.model.Owner;
import com.oceansfourteenth.petowners.service.api.IOwnerService;

/**
 * @author OceansFourteenth
 *
 */
@Service("ownerService")
public class OwnerServiceMongoTemplateImpl implements IOwnerService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Optional<List<Owner>> getOwners() {
		return Optional.ofNullable(mongoTemplate.findAll(Owner.class));
	}

	@Override
	public Optional<Owner> getOwner(long id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return Optional.ofNullable(mongoTemplate.findOne(query, Owner.class));
	}

	@Override
	public Optional<Owner> createOwner(@NotEmpty String name) throws IllegalArgumentException {
		Owner owner = new Owner();
		owner.setName(name);
		return createOwner(owner);
	}

	@Override
	public Optional<Owner> createOwner(@Valid Owner newOwner) throws IllegalArgumentException {
		newOwner.setId(mongoTemplate.count(new Query(), Owner.class) + 1);
		return Optional.ofNullable(mongoTemplate.insert(newOwner));
	}

}
