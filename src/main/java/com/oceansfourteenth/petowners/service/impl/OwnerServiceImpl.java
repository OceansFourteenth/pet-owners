/**
 * Created Sep 29, 2020 by brain
 */
package com.oceansfourteenth.petowners.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.oceansfourteenth.petowners.model.Owner;
import com.oceansfourteenth.petowners.service.api.IOwnerService;

/**
 * @author OceansFourteenth
 *
 */
@Service("ownerService")
public class OwnerServiceImpl implements IOwnerService {

	private static final List<Owner> owners = new ArrayList<>();

	@Override
	public Optional<List<Owner>> getOwners() {
		return Optional.ofNullable(owners);
	}

	@Override
	public Optional<Owner> getOwner(long id) {
		if (id < 0 || id >= owners.size()) {
			return Optional.empty();
		}

		return Optional.ofNullable(owners.get((int) id));
	}

	@Override
	public Optional<Owner> createOwner(String name) {
		validateName(name);
		Owner owner = new Owner();
		owner.setId(owners.size());
		owner.setName(name);
		owners.add(owner);
		return Optional.ofNullable(owner);
	}

	/**
	 * @param name
	 */
	private void validateName(String name) {
		if (StringUtils.isBlank(name))
			throw new IllegalArgumentException("Invalid name given: " + name);
	}

	@Override
	public Optional<Owner> createOwner(Owner newOwner) {
		validateName(newOwner.getName());
		newOwner.setId(owners.size());
		owners.add(newOwner);
		return Optional.ofNullable(newOwner);
	}

}
