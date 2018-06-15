/**
 * 
 */
package service.path;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author suleymancan Jun 9, 2018
 */

@Path("/customer-path")
public class CustomerResource {

	// default olarak customer-path
	// her HTTP istegi icin bir metot tanımlayabiliriz. @Path annotatiton
	// kullanılmayacaksa.
	@GET
	public String greeting() {
		String message = "CustomerResource#greeting";
		return message;
	}

	@GET
	@Path("/customers")
	public String getCustomers() {
		return "CustomerResource#getCustomers";
	}
}
