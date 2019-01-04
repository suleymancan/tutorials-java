/**
 * 
 */
package service.pathSegment;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.PathSegment;

/**
 * @author suleymancan Jun 9, 2018
 */

@Path("/car-pathSegment")
public class CarResourcePathSegment {

	// matrix parametresi genel format;
	// .../path/matrixParam=value; matrixParam2=value2;matrixParam3=value3
	@GET
	@Path("/car/{search : criteria}")
	public String getCar(@PathParam("search") PathSegment pathSegment) {
		String brand = pathSegment.getMatrixParameters().getFirst("brand");
		List<String> colors = pathSegment.getMatrixParameters().get("color");
		return "brand: " + brand + "colors: " + colors;
	}

}
