package com.wordpress.suleymancanblog.FirstMongoDBExam;

import com.wordpress.suleymancanblog.FirstMongoDBExam.customer.Customer;
import com.wordpress.suleymancanblog.FirstMongoDBExam.customer.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class FirstMongoDbExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMongoDbExamApplication.class, args);

	}

	private final CustomerRepository customerRepository;

	@Bean
	CommandLineRunner commandLine() {
		return  args -> {
			customerRepository.deleteAll();

			customerRepository.save(Customer.builder().firstName("Suleyman").lastName("Can").build());
			customerRepository.save(Customer.builder().firstName("Nazlisu").build());

			for(Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}

		};
	}



}

