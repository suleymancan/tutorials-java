package com.example.demojwt.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
