package com.people10.service;

import com.people10.model.Customer;
import com.people10.model.CustomerEntity;

public class PojoConversionToDao {

	public static CustomerEntity pojoToDao(Customer customer) {
		CustomerEntity customerEntity =  new CustomerEntity();
		customerEntity.setFirstName(customer.getFirstName());
		customerEntity.setLastName(customer.getLastName());
		customerEntity.setBirthDate(customer.getBirthDate());
		customerEntity.setEmail(customer.getEmail());
		customerEntity.setPassword(customer.getPassword());
		return customerEntity;
			
	}
}
