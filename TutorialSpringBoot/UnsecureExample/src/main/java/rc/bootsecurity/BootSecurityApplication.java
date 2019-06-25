package rc.bootsecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import rc.bootsecurity.users.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class BootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSecurityApplication.class, args);
	}



	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder passwordEncoder) {
		return args -> {

			if(!userRepository.findByUsername("admin").isPresent()) {

				roleService.save(Role.ADMIN);
				roleService.save(Role.MANAGER);
				roleService.save(Role.USER);

				final User user = new User();
				user.setUsername("user");
				user.setPassword(passwordEncoder.encode("password"));
				user.setAuthorities(new HashSet<Role>() {{
					add(roleService.findByRole(Role.RoleName.ROLE_USER));
				}});

				final User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("password"));
				admin.setAuthorities(new HashSet<Role>() {{
					add(roleService.findByRole(Role.RoleName.ROLE_ADMIN));
				}});

				final User manager = new User();
				manager.setUsername("manager");
				manager.setPassword(passwordEncoder.encode("password"));
				manager.setAuthorities(new HashSet<Role>() {{
					add(roleService.findByRole(Role.RoleName.ROLE_MANAGER));
				}});

				final List<User> userList = new ArrayList<>();
				userList.add(user);
				userList.add(admin);
				userList.add(manager);

				userRepository.saveAll(userList);
			}
		};
	}
}
