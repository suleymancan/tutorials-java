package com.mikroservice.animalservice.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

	private String name;

	private Byte age;
}
