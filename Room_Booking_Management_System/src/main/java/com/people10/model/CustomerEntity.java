package com.people10.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "reservation")
@Data
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "birthdate")
	private LocalDate birthDate;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password")
	@Size(min = 8, max = 10)
	private String password;
	
}
