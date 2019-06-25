package rc.bootsecurity.users;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
