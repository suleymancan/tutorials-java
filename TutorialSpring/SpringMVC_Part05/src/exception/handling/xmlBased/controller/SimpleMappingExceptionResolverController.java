/**
 * 
 */
package exception.handling.xmlBased.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.handling.xmlBased.model.DatabaseException;

/**
 * @author suleymancan Mar 22, 2018
 */
@Controller
public class SimpleMappingExceptionResolverController {

	@RequestMapping("/numberFormatException")
	public ModelAndView throwNumberFormatException() {
		throw new NumberFormatException();
	}

	@RequestMapping("/nullPointerException")
	public ModelAndView nullPointerException() {
		throw new NullPointerException();
	}

	@RequestMapping("/databaseException")
	String throwDatabaseException() throws Exception {
		throw new DatabaseException("DB100", "Db connection timeout...");
	}
}
