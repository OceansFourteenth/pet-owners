/**
 * Created Sep 29, 2020 by brain
 */
package com.oceansfourteenth.petowners.service.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.oceansfourteenth.petowners.model.Owner;

/**
 * @author OceansFourteenth
 *
 */
public interface IOwnerService {
	/**
	 * Retrieves all {@link Owners}.
	 * 
	 * @return A list of all Owners. The list will be empty if no Owner exists.
	 */
	Optional<List<Owner>> getOwners();

	/**
	 * Retrieves an {@link Owner} from the database.
	 * 
	 * @param id The id of the {@link Owner} to search for
	 * @return An Owner if one was found, or {@code null} if one was not
	 */
	Optional<Owner> getOwner(long id);

	/**
	 * Creates and saves an {@link Owner} with the given name.
	 * 
	 * @param name The {@link Owner}'s name. Must be non-null and non-empty
	 * @return The newly created {@link Owner}
	 * @throws IllegalArgumentException if any of the given values are invalid
	 */
	Optional<Owner> createOwner(@NotEmpty String name) throws IllegalArgumentException;

	/**
	 * Creates and saves an {@link Owner} with the given values.
	 * 
	 * @param newOwner	An Owner with the values to be used
	 * @return The newly created {@link Owner}
	 * @throws IllegalArgumentException if the given {@link Owner} is invalid
	 */
	Optional<Owner> createOwner(@Valid Owner newOwner) throws IllegalArgumentException;
}
