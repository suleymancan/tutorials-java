package com.example.kafka.model;

import lombok.*;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	private String name;

	private String dept;

	private Long salary;
}
