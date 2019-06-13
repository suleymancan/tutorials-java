package com.example.cassandra.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
@Table
@Getter
@Setter
public class User implements Serializable {

	@PrimaryKey()
	private Long id;

	private String name;

	private Long age;
}
