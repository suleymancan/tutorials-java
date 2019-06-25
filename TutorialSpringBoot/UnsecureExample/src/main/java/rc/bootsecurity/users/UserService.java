package rc.bootsecurity.users;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Optional<User> byUsername = userRepository.findByUsername(username);
		if(byUsername.isPresent()){
			return byUsername.get();
		}
		throw new UsernameNotFoundException("user not found! username:"+ username);
	}
}
