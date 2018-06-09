/**
 * 
 */
package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author suleymancan Jun 7, 2018
 */

@Path("/messages")
public class MessageService {

	// servis class'larımız singleton veya her istekte oluşabilir.
	@GET
	@Path("/greeting")
	public String getMessage() {
		return "Hello RESTEasy";
	}
}
