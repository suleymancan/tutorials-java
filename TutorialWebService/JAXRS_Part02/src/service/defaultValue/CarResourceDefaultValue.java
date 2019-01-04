/**
 * 
 */
package service.defaultValue;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author suleymancan Jun 15, 2018
 */
@Path("/car-defaultValue")
public class CarResourceDefaultValue {

	@GET
	@Path("/car")
	public String getCarById(@QueryParam("id") int id) {
		return "getCarById : " + id;
	}

	@GET
	@Path("/carDefault")
	public String getCarDefaultValueById(@DefaultValue("1000") @QueryParam("id") int id) {
		return "getCarDefaultValueById : " + id;
	}
}
