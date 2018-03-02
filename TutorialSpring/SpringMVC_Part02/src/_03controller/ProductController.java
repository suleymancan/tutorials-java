/**
 * 
 */
package _03controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author suleymancan Mar 1, 2018
 */
@Controller
@RequestMapping("/products")
public class ProductController {

	// desktop, tablet vs bir sey geldiginde buraya düsecek.
	// sonsuz tane method yazmaktan kurtulmus oluyoruz.
	// Burası generic hale gelmis oluyor.
	// tablet, pc vs. bilgisini String category'e bind etmis oluyoruz.
	// Buna göre ilgili akıs yapılabilir.
	@RequestMapping("/{category}")
	public String listProductsByCategory(@PathVariable("category") String category, Model model) {
		model.addAttribute("myMessage", "listProductsByCategory:" + category);
		return "productsPage";

	}

	// /product.detail?id=1000
	// bunu servlet'te request.getParameter(id) seklinde tanımlıyorduk.
	// @RequestParam, @MatrixVariable ve @PathParam'da isim belirtmezsek varsayılan
	// isim yanındaki
	// degisken ismi ile aynıdır olacaktır.
	// birden fazlar yanyana @RequestParam tanımlanabilir.
	@RequestMapping("/product.detail")
	public String productDetail(@RequestParam int productId,
			@RequestParam(required = false, name = "brand") String brand, Model model) {
		model.addAttribute("myMessage", "productDetail: " + productId + " brand: " + brand);
		return "productsPage";
	}

	@RequestMapping("/product.moredetail/{matrixVariables}")
	public String moreDetailParameter(@MatrixVariable(pathVar = "matrixVariables") List<String> colors,
			@MatrixVariable(pathVar = "matrixVariables", name = "lowPrice") String lowPrice,
			@MatrixVariable(pathVar = "matrixVariables", name = "highPrice") String highPrice, Model model) {
		model.addAttribute("myMessage", "moreDetailParameter: " + lowPrice + " " + highPrice + " " + colors);
		return "productsPage";
	}
}
