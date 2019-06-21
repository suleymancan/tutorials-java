package com.example.demojwt.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	boolean save(User user){
		try {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Optional<User> byUsername = userRepository.findByUsername(username);
		if(!byUsername.isPresent()){
			throw new UsernameNotFoundException("user not found!");
		}
		return new org.springframework.security.core.userdetails.User(byUsername.get().getUsername(), byUsername.get().getPassword(), Collections.emptyList());

	}
}
