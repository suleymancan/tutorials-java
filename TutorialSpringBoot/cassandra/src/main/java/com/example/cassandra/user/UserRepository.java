package com.example.cassandra.user;

import org.springframework.data.repository.CrudRepository;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
interface UserRepository extends CrudRepository<User, Long> {

}
