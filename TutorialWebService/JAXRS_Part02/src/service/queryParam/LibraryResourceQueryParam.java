/**
 * 
 */
package service.queryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author suleymancan Jun 14, 2018
 */

@Path("/library-queryParam")
public class LibraryResourceQueryParam {

	@GET
	@Path("/book")
	public String getBookById(@QueryParam("id") int id) {
		return "getBookById: " + id;
	}

	// http://localhost:8080/JAXRS_Part02/root-path/library-queryParam/book?id=2727

	@GET
	@Path("/books")
	public String getBooks(@QueryParam("start") int start, @QueryParam("end") int end) {
		return "book start: " + start + ", end: " + end;
	}

	// birden fazla parametre kullanımı
	// http://localhost:8080/JAXRS_Part02/root-path/library-queryParam/books?start=27&end=2727

	// Context: farklı farklı class'lar icin inject islemi gerceklestirir.
	// parametreleri cekmek icin;
	// http://localhost:8080/JAXRS_Part02/root-path/library-queryParam/book-uri-info?id=27
	@GET
	@Path("/book-uri-info")
	public String getBooksURIInfo(@Context UriInfo uriInfo) {
		String id = uriInfo.getQueryParameters().getFirst("id");
		return "getBookURIInfo:" + id;
	}

}
