/**
 * 
 */
package _01controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @author suleymancan Feb 27, 2018
 */
public class Page1Controller extends AbstractController {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new ModelAndView("myPage1");
		mv.addObject("myMessage", "hello page1 controller");
		return mv;
	}

}
