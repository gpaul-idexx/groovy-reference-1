package com.idexx.reference

import com.idexx.reference.groovy.domain.Pet
import com.idexx.reference.groovy.domain.PetOwner

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When
import static cucumber.api.groovy.Hooks.Before

/**
 *
 * @author gpaul
 * @since Jan 26, 2016
 */

Before() {
    dave = new PetOwner()
}

Given(~'^Dave has (\\d+) pets named:$') { pets, names ->
    names.raw().each {
        dave.pets += new Pet(name: it[0])
    }
}

When(~'^Dave retrieves his list of pets$') { ->
    davesPets = dave.pets
}

Then(~'^It should include:$') { names ->
    davesPets.collect { it.name } == names.raw().collect { it[0] }
}


