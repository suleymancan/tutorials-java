/**
 * 
 */
package _02controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author suleymancan Feb 27, 2018
 */

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/String", method = RequestMethod.GET)
	public String testString(Model model) {
		model.addAttribute("myMessage", "string return!");
		return "modelAndStringTest";
	}

	@RequestMapping(value = "/ModelAndView", method = RequestMethod.GET)
	public ModelAndView testModelAndView() {
		ModelAndView mv = new ModelAndView("modelAndStringTest");
		mv.addObject("myMessage", "modelAndView return!");
		return mv;
	}
}
