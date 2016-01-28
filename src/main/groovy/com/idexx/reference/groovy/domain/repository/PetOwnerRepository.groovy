package com.idexx.reference.groovy.domain.repository

import com.idexx.reference.groovy.domain.PetOwner
import org.springframework.data.repository.CrudRepository

/**
 *
 * @author gpaul
 * @since Jan 27, 2016
 */
interface PetOwnerRepository extends CrudRepository<PetOwner, Integer> {

    List<PetOwner> findByName(String name);
}