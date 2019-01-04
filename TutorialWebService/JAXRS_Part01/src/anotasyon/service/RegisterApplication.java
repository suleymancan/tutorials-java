/**
 * 
 */
package anotasyon.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author suleymancan Jun 7, 2018
 */
@ApplicationPath("/")
// /* kullanma, sorun cıkar. (/root-path) kullanılabilir.
public class RegisterApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public RegisterApplication() {
		singletons.add(new MessageService());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.core.Application#getSingletons()
	 */
	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return singletons;
	}

}
