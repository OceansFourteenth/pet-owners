/**
 * 
 */
package com.oceansfourteenth.petowners.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.oceansfourteenth.petowners.model.Owner;

/**
 * @author OceansFourteenth
 *
 */
@Repository("ownerMongoRepository")
public interface OwnerMongoRepository extends MongoRepository<Owner, Long> {

}
