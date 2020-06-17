package com.people10.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.people10.model.Customer;
import com.people10.model.CustomerEntity;
import com.people10.service.ReservationServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservationController {
	
	@Autowired
	private ReservationServiceImpl reservationService;
	
	/**
	 * creates customer reservation in the database provided the customer information.
	 * 
	 * @param customer object
	 * @return returns customer entity with the customer id.
	 */
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<CustomerEntity> addReservation(@RequestBody Customer customer) {
		
		CustomerEntity customerEntity = reservationService.addReservation(customer);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customerEntity);
		
	}
	
	/**
	 * retieves the customer details such as first name, last name and other details provided the customer id
	 * @param customer_id
	 * @return customer_entity for the given customer id
	 */
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerEntity> getReservation(@PathVariable Long id) {
		
		CustomerEntity customerEntity = reservationService.getReservation(id);
		
		return ResponseEntity.ok(customerEntity);
		
	}
}
