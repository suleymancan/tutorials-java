/**
 * 
 */
package service.formParam;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.Form;

/**
 * @author suleymancan Jun 14, 2018
 */
@Path("/person-formParam")
public class PersonResourceFormParam {

	@POST
	@Path("/addPerson")
	public String addPerson(@FormParam("name") String name, @FormParam("surname") String surname) {
		// mesela, obje olusturup insret attımm...
		return "insert ok... " + name + "..." + surname;

	}

	// Form icin
	// @FomrParam'ı ilgili model class'ında degiskene verdik.
	@POST
	@Path("/addPersonFormAnnotation")
	public String addPersonFormAnnotation(@Form Person person) {
		return "addPersonFormAnnotation " + person.toString();
	}
}
