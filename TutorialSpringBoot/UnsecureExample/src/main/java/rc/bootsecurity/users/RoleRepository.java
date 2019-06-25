package rc.bootsecurity.users;

import org.springframework.data.repository.CrudRepository;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
public interface RoleRepository extends CrudRepository<Role, Role.RoleName> {

}
