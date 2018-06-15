/**
 * 
 */
package service.cookieParam;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * @author suleymancan Jun 15, 2018
 */
@Path("/user-cookieParam")
public class UserResourceCookieParam {

	@GET
	@Path("/addCookie")
	public Response addCookie() {
		String resultMessage = "addCookie is invoked!";
		ResponseBuilder builder = Response.ok(resultMessage);
		builder.cookie(new NewCookie("myCookieName", "myCookieValue"));
		return builder.build();
	}

	@GET
	@Path("/getCookie")
	public Response getCookie(@CookieParam("myCookieName") String cookie) {
		String resultMessage = "getCookie is invoked!";
		ResponseBuilder builder = Response.ok(resultMessage + " " + cookie);
		return builder.build();

	}

	// cookie'ler özel header bilgileridir. @Context'te kullanılabilir.

	@GET
	@Path("/getCookieWithContext")
	public Response getCookieWithContext(@Context HttpHeaders headers) {
		String result = "getCookie#WithContext";
		for (String name : headers.getCookies().keySet()) {
			javax.ws.rs.core.Cookie cookie = headers.getCookies().get(name);
			result = result + "Cookie: " + cookie.getName() + ", " + cookie.getValue();
		}
		ResponseBuilder builder = Response.ok(result);
		return builder.build();
	}

}
