package com.idexx.reference

import com.idexx.reference.groovy.domain.Pet
import com.idexx.reference.groovy.domain.PetOwner

import static cucumber.api.groovy.EN.*
import static cucumber.api.groovy.Hooks.Before

/**
 *
 * @author gpaul
 * @since Jan 26, 2016
 */

Before() {
    dave = new PetOwner()
}

Given(~'^Dave has (\\d+) pets named (\\w+), (\\w+) and (\\w+)$') { pets, name1, name2, name3 ->
    dave.pets += new Pet(name: name1)
    dave.pets += new Pet(name: name2)
    dave.pets += new Pet(name: name3)
}

When(~'^Dave retrieves his list of pets$') { ->
    davesPets = dave.pets
}

Then(~'^It should include (\\w+), (\\w+) and (\\w+)$') { name1, name2, name3 ->
    davesPets.collect { it.name } == [name1, name2, name3]
}


