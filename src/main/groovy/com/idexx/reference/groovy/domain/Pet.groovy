package com.idexx.reference.groovy.domain

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.ManyToOne

/**
 *
 * @author gpaul
 * @since Jan 27, 2016
 */
@Entity
@ToString
class Pet extends BaseEntity {
    String name
    @ManyToOne
    PetOwner petOwner
}

