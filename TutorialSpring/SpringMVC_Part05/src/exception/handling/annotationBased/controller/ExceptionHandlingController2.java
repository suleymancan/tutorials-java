/**
 * 
 */
package exception.handling.annotationBased.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author suleymancan Mar 22, 2018
 */

@Controller
public class ExceptionHandlingController2 {

	@RequestMapping("/sqlException2")
	String throwSQLException() throws SQLException {
		System.out.println("sql exception 2");
		throw new SQLException();
	}

	@RequestMapping("/indexOutOfBoundsException2")
	String throwIndexOutOfBoundsException() {
		System.out.println("indexOutOfBoundsException 2");
		throw new IndexOutOfBoundsException();

	}
}
