package com.people10.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people10.Controller.UserNotFoundException;
import com.people10.model.Reservation;
import com.people10.repository.ReservationRepository;
@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public void addReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	public Optional<Reservation> getReservation(Long id) {
		
		
		 Optional<Reservation> findById = reservationRepository.findById(id);
		 if(findById==null)
				throw new UserNotFoundException("id-"+id);
		return findById;
		
	}

}
