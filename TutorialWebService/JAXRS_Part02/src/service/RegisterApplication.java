/**
 * 
 */
package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import service.beanParam.ProductResourceBeanParam;
import service.cookieParam.UserResourceCookieParam;
import service.defaultValue.CarResourceDefaultValue;
import service.formParam.PersonResourceFormParam;
import service.headerParam.LoginResourceHeaderParam;
import service.matrixParam.CarResourceMatrixParam;
import service.path.CustomerResource;
import service.pathParam.CustomerResourcePathParam;
import service.pathParam.OrderResourcePathParam;
import service.pathSegment.CarResourcePathSegment;
import service.queryParam.LibraryResourceQueryParam;

/**
 * @author suleymancan Jun 9, 2018
 */

@ApplicationPath("/root-path")
public class RegisterApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	/**
	 * 
	 */
	public RegisterApplication() {

		singletons.add(new CustomerResource());
		singletons.add(new CustomerResourcePathParam());
		singletons.add(new OrderResourcePathParam());
		singletons.add(new CarResourcePathSegment());
		singletons.add(new CarResourceMatrixParam());
		singletons.add(new LibraryResourceQueryParam());
		singletons.add(new PersonResourceFormParam());
		singletons.add(new LoginResourceHeaderParam());
		singletons.add(new UserResourceCookieParam());
		singletons.add(new ProductResourceBeanParam());
		singletons.add(new CarResourceDefaultValue());

	}

	/**
	 * @return the singletons
	 */
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
