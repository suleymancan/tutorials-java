/**
 * 
 */
package configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author suleymancan Mar 2, 2018
 */
public class RegisterSpring implements WebApplicationInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.
	 * ServletContext)
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(BeanConfiguration.class);

		// servletlerin dinamik olarak eklenmesi;
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcherServlet);
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);

	}

}
