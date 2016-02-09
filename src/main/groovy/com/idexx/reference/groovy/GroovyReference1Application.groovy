package com.idexx.reference.groovy

import com.idexx.reference.groovy.domain.PetOwner
import com.idexx.reference.groovy.domain.repository.PetOwnerRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.endpoint.AbstractEndpoint
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

    class AwsInfo extends AbstractEndpoint<Map<String, Object>> {

        private def keys = ['ami-id', 'hostname', 'iam/info', 'instance-id', 'instance-type', 'local-hostname',
                            'local-ipv4', 'placement/availability-zone', 'public-hostname', 'public-ipv4',
                            'reservation-id', 'security-groups', 'instance-identity']

        Map<String, Object> info = [:]

        AwsInfo() {
            super('ec2-info', true)
        }

        @Override
        Map<String, Object> invoke() {
            keys.each { key ->
                info[key] = environment.getProperty(key, "N/A")
            }
            return info
        }
    }

    @Bean
    AwsInfo awsInstanceInfo() {
        new AwsInfo()
    }
}
