package com.mikroservice.storeapp.store;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@FeignClient("animal-service")
public interface AnimalServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	List<Animal> getAnimals();

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	Animal getAnimalById(@PathVariable Integer id);

}
