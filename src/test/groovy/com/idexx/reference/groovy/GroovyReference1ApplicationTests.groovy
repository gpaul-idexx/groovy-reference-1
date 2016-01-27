package com.idexx.reference.groovy

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@SpringApplicationConfiguration(classes = GroovyReference1Application)
@WebAppConfiguration
class GroovyReference1ApplicationTests extends Specification {

    @Autowired
    ApplicationContext applicationContext

    def "the spring context starts"() {
        expect:
        applicationContext.containsBean("groovyReference1Application")
    }

}
