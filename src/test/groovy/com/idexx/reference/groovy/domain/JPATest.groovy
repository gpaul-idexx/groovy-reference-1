package com.idexx.reference.groovy.domain

import com.idexx.reference.groovy.GroovyReference1Application
import com.idexx.reference.groovy.domain.repository.PetOwnerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import spock.lang.Specification

/**
 *
 * @author gpaul
 * @since Jan 27, 2016
 */
@SpringApplicationConfiguration(classes = GroovyReference1Application)
class JPATest extends Specification {

    @Autowired
    PetOwnerRepository repository

    def "it can store a pet owner in the database and retrieve it"() {
        given:
        def dave = new PetOwner(name: "Dave")
        when:
        def dbDave = repository.save(dave)
        then:
        dbDave.id != null
        dbDave.name == dave.name
    }

    def "it can store a pet owner with pets in the database and retrieve them"() {
        given:
        def dave = new PetOwner(name: "Dave")
        dave.pets += new Pet(name: "Fluffy")
        when:
        def dbDave = repository.save(dave)
        then:
        dbDave.pets[0].name == "Fluffy"
    }

}