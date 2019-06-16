package com.mikroservice.storeapp.store;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Service
@AllArgsConstructor
public class AnimalService {

	private final RestTemplate restTemplate;

	private final AnimalServiceClient animalServiceClient;

	@HystrixCommand(fallbackMethod = "fallback")
	public List<Animal> getAnimals(){
		return restTemplate.getForObject("http://ANIMAL-SERVICE/all", List.class);
	}

	public Animal getAnimalById(Integer id){
		return animalServiceClient.getAnimalById(id);
	}

	public List<Animal> fallback(){
		final List<Animal> result = new ArrayList<>();
		result.add(new Animal("Yok", (byte)0));
		return result;
	}



}
