/**
 * 
 */
package service.pathParam;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author suleymancan Jun 9, 2018
 */

@Path("/order-pathParam")
public class OrderResourcePathParam {

	// / yerine farklı karakter de kullanılabilir.
	@GET
	@Path("/order/{day}/{month}/{year}")
	public String getOrderByDate(@PathParam("day") int day, @PathParam("month") int month,
			@PathParam("year") int year) {
		LocalDate date = LocalDate.of(year, month, day);
		return date.toString();
	}

	// REGEX
	// id degerini sadece int istiyoruz, int dışındakiler geçersiz! (INVALID)

	@GET
	@Path("/orderById/{id: \\d+}")
	public String getOrderById(@PathParam("id") int id) {
		return "getOrderById" + id;
	}

	@GET
	@Path("/orderByName/{name: Order-\\d+\\w+}")
	public String getOrderByName(@PathParam("name") String orderName) {
		return "getOrderByName: " + orderName;
	}
}
