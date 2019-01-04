/**
 * 
 */
package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import controller.PersonController;

/**
 * @author suleymancan Mar 2, 2018
 */

// bean createPersonController yerine kullanılabilir;
// @CompentScan(basePackages="controller")
@Configuration
public class BeanConfiguration {

	@Bean
	public PersonController createPersonController() {
		return new PersonController();
	}

	@Bean
	public ViewResolver createViewResoulver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
