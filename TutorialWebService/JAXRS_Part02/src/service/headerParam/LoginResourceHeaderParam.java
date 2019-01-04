/**
 * 
 */
package service.headerParam;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 * @author suleymancan Jun 14, 2018
 */
@Path("/login-headerParam")
public class LoginResourceHeaderParam {

	@GET
	@Path("/userAgent")
	// header bilgilerini inject edebiliriz.
	public String getUserAgent(@HeaderParam("user-agent") String userAgent) {
		return "userAgent" + userAgent;
	}

	// Context'te kullanabiliriz.

	@GET
	@Path("/headerInformation")
	public String getHeadersInformatin(@Context HttpHeaders headers) {
		String message = "";
		for (String headerName : headers.getRequestHeaders().keySet()) {
			message = message + "<br/>" + headerName + ": " + headers.getRequestHeader(headerName);
		}
		return message;

	}

}
