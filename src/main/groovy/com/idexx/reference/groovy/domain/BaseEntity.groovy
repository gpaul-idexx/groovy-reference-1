package com.idexx.reference.groovy.domain

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 *
 * @author gpaul
 * @since Jan 27, 2016
 */
@MappedSuperclass
class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id
}
