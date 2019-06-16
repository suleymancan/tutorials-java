package com.mikroservice.animalservice.animals;

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
public class AnimalRestController {

	private Map<Integer, Animal> animalMap = new HashMap<>();

	@PostConstruct
	public void init(){
		animalMap.put(1, new Animal("Peri", (byte) 1));
		animalMap.put(2, new Animal("Kuçu",(byte) 2));
		animalMap.put(3, new Animal("Pisi", (byte)3));
	}

	@GetMapping("/all")
	public Collection<Animal> getAll(){
		log.info("/all is running");

		return animalMap.values();
	}

	@GetMapping("/{id}")
	public Animal getId(@PathVariable Integer id){

		return animalMap.get(id);
	}
}
