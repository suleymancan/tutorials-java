/**
* 
*/
package service.beanParam;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author suleymancan Jun 15, 2018
 */

@Path("product-beanParam")
public class ProductResourceBeanParam {

	@GET
	@Path("/getProduct/{category}")
	// http://localhost:8080/JAXRS_Part02/root-path/product-beanParam/getProduct/computer?id=100
	public String getProduct(@BeanParam Product product) {
		return "getProduct: " + product.toString();
	}
}
