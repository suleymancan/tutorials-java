package com.example.demojwt.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/sign-up")
	public boolean signUp(@RequestBody User user){
		return userService.save(user);
	}

}
