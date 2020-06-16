package com.people10.service;

import com.people10.model.Customer;
import com.people10.model.CustomerEntity;

public interface ReservationService {

	CustomerEntity getReservation(Long id);

	CustomerEntity addReservation(Customer reservation);

}
