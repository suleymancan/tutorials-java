package com.wordpress.suleymancanblog.FirstMongoDBExam.customer;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Created on December, 2018
 *
 * @author suleymancan
 */

@Getter
@Setter
@Builder
@ToString
public class Customer {

	@Id
	private String id;

	private String firstName;

	private String lastName;
}
