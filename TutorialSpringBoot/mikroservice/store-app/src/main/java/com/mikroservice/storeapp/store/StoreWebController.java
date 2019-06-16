package com.mikroservice.storeapp.store;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Controller
@AllArgsConstructor
public class StoreWebController {

	private final AnimalService animalService;

	private final BookServiceClient bookServiceClient;

	@GetMapping("/animals")
	public String getAnimals(Model model){
		model.addAttribute("animals", animalService.getAnimals());
		return "animals";
	}

	@GetMapping("/books")
	public String getBooks(Model model){
		model.addAttribute("books", bookServiceClient.getAll());
		return "books";
	}

}
