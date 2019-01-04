/**
 * 
 */
package exception.handling.annotationBased.controller;

import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author suleymancan Mar 22, 2018
 */
@Controller
public class ExceptionHandlingController {

	@RequestMapping("/sqlException")
	String throwSQLException() throws SQLException {
		System.out.println("sql exception...");
		throw new SQLException();

	}

	@RequestMapping("/indexOutOfBoundsException")
	String throwIndexOutOfBoundsException() {
		System.out.println("IndexOutOfBoundsException...");
		throw new IndexOutOfBoundsException();

	}

	// sadece ilgili controllerdan sorumlu
	// bu tip bir hata oldugunda buraya düssün.
	@ExceptionHandler({ SQLException.class, SQLDataException.class })
	public String handleSQLException() {
		return "exception.handling.annotationBased.view/sqlException";
	}

	@ExceptionHandler({ IndexOutOfBoundsException.class })
	public ModelAndView handleIndexOutOfBoundsException(HttpServletRequest req, Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("exception.handling.annotationBased.view/indexOutOfBoundsException");
		return modelAndView;
	}
}
