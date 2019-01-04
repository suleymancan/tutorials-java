/**
 * 
 */
package anotasyon.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author suleymancan Jun 7, 2018
 */
@Path("/Amessages")
public class MessageService {
	@GET
	@Path("/greeting")
	public String getMessage() {
		return "Hello RESTEasy";
	}
}
