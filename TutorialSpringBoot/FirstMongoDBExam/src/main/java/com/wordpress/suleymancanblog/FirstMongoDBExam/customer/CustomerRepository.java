package com.wordpress.suleymancanblog.FirstMongoDBExam.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on December, 2018
 *
 * @author suleymancan
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
