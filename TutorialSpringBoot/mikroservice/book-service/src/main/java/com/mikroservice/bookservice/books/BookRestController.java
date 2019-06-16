package com.mikroservice.bookservice.books;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@RestController
@Slf4j
public class BookRestController {

	private final Map<Integer, Book> bookMap = new HashMap<>();

	@PostConstruct
	private void init(){
		bookMap.put(1, new Book("Genclerle Basbasa", "Ali Fuad Basgil"));
		bookMap.put(2, new Book("Suc ve Ceza", "Dostoyevski"));

	}

	@GetMapping("/all")
	public Collection<Book> getAll(){
		log.info("getAll");
		return bookMap.values();
	}

	@GetMapping("/{id}")
	public Book getId(@PathVariable Integer id){
		return bookMap.get(id);
	}
}
