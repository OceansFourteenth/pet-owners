/**
 * Created Sep 29, 2020 by brain
 */
package com.oceansfourteenth.petowners.service.api;

import java.util.List;
import java.util.Optional;

import com.oceansfourteenth.petowners.model.Owner;

/**
 * @author OceansFourteenth
 *
 */
public interface IOwnerService {
	Optional<List<Owner>> getOwners();

	Optional<Owner> getOwner(long id);

	Optional<Owner> createOwner(String name);

	Optional<Owner> createOwner(Owner newOwner);
}
