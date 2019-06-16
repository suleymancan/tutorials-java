package com.mikroservice.storeapp.store;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@FeignClient("book-service")
public interface BookServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	List<Book> getAll();

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	Animal getAnimalById();
}
