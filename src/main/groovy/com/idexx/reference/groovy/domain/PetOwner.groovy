package com.idexx.reference.groovy.domain

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.OneToMany
/**
 *
 * @author gpaul
 * @since Jan 27, 2016
 */
@Entity
@ToString
class PetOwner extends BaseEntity {
    String name
    @OneToMany(mappedBy = "petOwner")
    List<Pet> pets = []


}

