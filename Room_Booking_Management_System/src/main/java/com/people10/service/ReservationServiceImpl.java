package com.people10.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people10.exception.UserNotFoundException;
import com.people10.model.Customer;
import com.people10.model.CustomerEntity;
import com.people10.repository.ReservationRepository;
@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public CustomerEntity addReservation(Customer customer) {
		CustomerEntity customerEntity = PojoConversionToDao.pojoToDao(customer);
		CustomerEntity customerAdded = reservationRepository.save(customerEntity);
		return customerAdded;
	}

	@Override
	public CustomerEntity getReservation(Long id) {
		 Optional<CustomerEntity> optionalUser = reservationRepository.findById(id);
		 if(!optionalUser.isPresent()) {
			 throw new UserNotFoundException("No user found for the given id : " + id);
		 }
		return optionalUser.get();
		
	}

}
