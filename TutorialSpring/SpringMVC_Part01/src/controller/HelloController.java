/**
 * 
 */
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import service.HelloService;

/**
 * @author suleymancan Feb 21, 2018
 */

@Controller
// requestMapping sınıf ve metot seviyesinde kullanılabilir.
@RequestMapping(value = "/springmvc")
public class HelloController {

	@Autowired
	private HelloService helloService;

	// bir request'i karşıladıgını belirtmek icin @RequestMapping ile belirtiyoruz.
	// Controller'daki metotta geriye ilgili view'in ismini döneceğiz.

	// @RequestMapping(value="/hello", method=RequestMethod.GET)
	// varsayılan olarak GET
	@RequestMapping("/hello")
	public String printHello(ModelMap map) {
		// burada full path /WEB-INF/View/helloPage.jsp vermek yerine appContext'te
		// prefix suffix kullandım.

		// ModelMap map= new ModelMap() seklinde kendimizde olusturabiliriz.
		// metoda parametre yazdıgımızda spring kendisi ayarlyor.

		// service'den data aldım. bu datayı view'de göstermek icin, servlet&jsp de
		// attribute ile setAttribute ile ekleyip dispatch yapıyordum. Bunu MVC de
		// yapmak için çeşitli class'lar
		// var. ModelAndView ModelMap vs.
		String created = helloService.createMessage();
		map.addAttribute("myMessage", created);
		return "helloPage";
	}
}
