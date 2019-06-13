package com.example.cassandra.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private final UserRepository userRepository;

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		return ResponseEntity.ok(userRepository.save(user));

	}

	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		return (ResponseEntity<List<User>>) userRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		final Optional<User> byId = userRepository.findById(id);
		if(byId.isPresent()){
			return ResponseEntity.ok(byId.get());
		}
		return (ResponseEntity<?>) ResponseEntity.notFound();
	}

}
