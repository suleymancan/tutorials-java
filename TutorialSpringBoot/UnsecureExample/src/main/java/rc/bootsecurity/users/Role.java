package rc.bootsecurity.users;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

	public static final Role MANAGER = new Role(Role.RoleName.ROLE_MANAGER);

	public static final Role ADMIN = new Role(RoleName.ROLE_ADMIN);

	public static final Role USER = new Role(RoleName.ROLE_USER);

	@Column(nullable = false, unique = true)
	@Id
	private RoleName roleName;

	@Override
	public String getAuthority() {
		return this.roleName.name();
	}

	@Getter
	@AllArgsConstructor
	public enum RoleName{
		ROLE_MANAGER("Manager"), ROLE_USER("User"), ROLE_ADMIN("Admin");

		private final String role;

	}
}
