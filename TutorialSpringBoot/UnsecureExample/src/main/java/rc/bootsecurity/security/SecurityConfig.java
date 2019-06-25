package rc.bootsecurity.security;

import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import rc.bootsecurity.users.UserService;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserService userService;

	private final BCryptPasswordEncoder passwordEncoder;



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/index", "/h2_console").permitAll()
				.antMatchers("/profile/index").authenticated()
				.antMatchers("/api/public/test1", "/api/public/**").hasRole("USER")
				.antMatchers("/admin/index").hasRole("ADMIN")
				.antMatchers("/management/index").hasAnyRole("ADMIN","MANAGER")
				.and().formLogin().loginPage("/login").permitAll()
				.and().logout().permitAll()
				.and().rememberMe().userDetailsService(userService);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}


}
