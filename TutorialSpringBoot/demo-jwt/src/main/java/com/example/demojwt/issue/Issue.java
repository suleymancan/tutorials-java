package com.example.demojwt.issue;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Entity
@Getter
@Setter
class Issue {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
}
