package com.mikroservice.bookservice.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

	private String name;

	private String author;
}
