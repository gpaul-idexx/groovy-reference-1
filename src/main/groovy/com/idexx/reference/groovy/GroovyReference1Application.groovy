package com.idexx.reference.groovy

import com.idexx.reference.groovy.domain.PetOwner
import com.idexx.reference.groovy.domain.repository.PetOwnerRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class GroovyReference1Application {

    static void main(String[] args) {
        SpringApplication.run GroovyReference1Application, args
    }

    @Bean
    String init(PetOwnerRepository petOwnerRepository) {
        petOwnerRepository.save([
                new PetOwner(name: "Bob"),
                new PetOwner(name: "Dave"),
                new PetOwner(name: "Jenny"),
                new PetOwner(name: "Felix")
        ])

        "yep"
    }
}
