/**
 * 
 */
package service.matrixParam;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;

/**
 * @author suleymancan Jun 14, 2018
 */

@Path("/car-matrixParam")
public class CarResourceMatrixParam {

	@GET
	@Path("/car")
	// http://localhost:8080/JAXRS_Part02/root-path/car-matrixParam/car;brand=bmv;color=red;color=black
	public String getCar(@MatrixParam("brand") String brand, @MatrixParam("color") List<String> colors) {

		return "brand" + brand + "colors" + colors;

	}
}
