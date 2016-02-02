package com.idexx.reference.groovy

import com.idexx.reference.groovy.domain.Pet
import spock.lang.Specification


/**
 *
 * @author gpaul
 * @since Feb 02, 2016
 */
class BadTest extends Specification {

    def "it fails when there is a bad test"() {
        expect:
        1 == 2
    }

    def "spock is awesome"() {
        Pet fluffy = new Pet(name: "fluffy")
        Pet rover = new Pet(name: "rover")
        expect:
        fluffy == rover

    }
}