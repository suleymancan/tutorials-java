package com.example.demojwt.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Entity
@Table(name = "T_USER")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	private String password;
}
