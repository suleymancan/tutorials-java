package com.example.kafka.controller;

import com.example.kafka.model.User;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@RestController
@RequestMapping("/kafka/publish")
@AllArgsConstructor
public class ResourceController {

	private static final String TOPIC = "TutorialTopic";

	private final KafkaTemplate<String, User> kafkaTemplate;
	//private final KafkaTemplate<String, String> kafkaTemplate;
	//	@GetMapping("/string/{name}")
	//	public String postName(@PathVariable final String name){
	//
	//		kafkaTemplate.send(TOPIC, name);
	//		return "Published successfully";
	//	}

	@GetMapping("/user/{name}")
	public String postUser(@PathVariable final String name) {

		kafkaTemplate.send(TOPIC, new User(name, "IT", 1L));
		return "Published successfully";
	}

}
