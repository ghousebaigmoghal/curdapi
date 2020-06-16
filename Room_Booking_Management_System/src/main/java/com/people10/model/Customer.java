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

@Data
public class Customer {
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;
	
	private String email;
	
	private String password;

}
