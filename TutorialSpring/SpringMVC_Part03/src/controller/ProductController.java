/**
 * 
 */
package controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Product;
import service.ProductService;

/**
 * @author suleymancan Mar 7, 2018
 */

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	// products url'e istek gelince bu metot çalisir.
	// tüm ürünleri listeleyeceğim.
	@RequestMapping
	public String defaultPage(Model model) {

		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {

		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}

	// ürün detay sayfası
	@RequestMapping("/product")
	public String getProductById(@RequestParam(name = "id") String productId, Model model) {
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "productDetail";
	}

	// category yapısı, path variable uygun.

	@RequestMapping("/category/{categoryName}")
	public String listProductsByCategoryName(@PathVariable(name = "categoryName") String categoryName, Model model) {
		List<Product> products = productService.getProductsByCategory(categoryName);
		model.addAttribute("products", products);
		return "productList";
	}

	// markaya göre filtreleme

	@RequestMapping("/brand/{brands}")
	public String listProductsByBrands(@MatrixVariable(pathVar = "brands") List<String> brands, Model model) {
		List<Product> products = productService.getProductsByBrands(brands);
		model.addAttribute("products", products);
		return "productList";
	}

	// ModelAttribute, view'deki ile buradaki isim aynı olmalı.
	// ModelAttribute, formdan girilen degerleri Product'un ilgili alanlarına
	// otomatik bind edecek.
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProductPage(@ModelAttribute("newProduct") Product productToAdded) {
		System.out.println("addProductPage#GET invoked!");
		// default yazi. (initialize)
		productToAdded.setDescription("aciklama");
		productToAdded.setCategory("Laptop");
		return "productAdd";
	}

	// view'deki checkbox vs alanları dinamik olarak olusturmak icin;
	// Db'den vs cekilebilir, burada elle ekliyorum.
	// Referans data mantıgı.
	@ModelAttribute("manufacturerList")
	public List<String> prepareManufacturers() {
		System.out.println("prepareManufacturers#invoked!");
		return Arrays.asList("Apple", "Google", "Samsung");
	}

	@ModelAttribute("categoryList")
	public List<String> prepareCategories() {
		System.out.println("categoryList#invoked");
		return Arrays.asList("Tablet", "Tv", "Phone");
	}

	@ModelAttribute("conditionMap")
	public Map<String, String> prepareConditions() {
		System.out.println("prepareConditions#invoked!");
		Map<String, String> conditions = new LinkedHashMap<>();
		conditions.put("new", "New");
		conditions.put("old", "Old");
		conditions.put("ref", "Ref");
		return conditions;
	}

	// post kısmı
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProductPageSubmit(@ModelAttribute("newProduct") Product productToAdded) {
		productService.addProduct(productToAdded);
		return "redirect:/products";

	}

}
