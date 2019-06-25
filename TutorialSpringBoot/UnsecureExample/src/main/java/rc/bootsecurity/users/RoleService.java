package rc.bootsecurity.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Service
@AllArgsConstructor
public class RoleService {

	private final RoleRepository roleRepository;

	public void save(Role role){
		roleRepository.save(role);
	}

	public Role findByRole(Role.RoleName roleName){

		return roleRepository.findById(roleName).orElseThrow(IllegalArgumentException::new);
	}
}
