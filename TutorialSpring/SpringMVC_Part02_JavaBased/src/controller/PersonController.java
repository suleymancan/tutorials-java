/**
 * 
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author suleymancan Mar 2, 2018
 */
@Controller
@RequestMapping("/persons")
public class PersonController {

	@RequestMapping("/person.detail")
	public ModelAndView personDetail(ModelAndView mv) {
		mv.setViewName("personMessage");
		mv.addObject("myMessage", "PersonController#personDetail");
		return mv;
	}
}
