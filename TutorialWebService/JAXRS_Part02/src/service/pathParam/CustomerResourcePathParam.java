/**
 * 
 */
package service.pathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author suleymancan Jun 9, 2018
 */

@Path("/customer-pathParam")
public class CustomerResourcePathParam {

	// id bilgisine göre ilgili customer'ı dönecegiz. dönüs tipi, xml, json,
	// customer'da olabilirdi.
	// /customer/{id] ile @PathParam("id") aynı olmalı. aksi halde hata çıkar.
	@GET
	@Path("/customer/{id}")
	public String getCustomerByid(@PathParam("id") String customerId) {
		// customer id'ye göre datayı getir.
		return "CustomerResourcePathParam#getCustomerById: " + customerId;
	}
}
