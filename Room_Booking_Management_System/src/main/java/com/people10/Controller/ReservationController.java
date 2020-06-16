package com.people10.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.people10.model.Reservation;
import com.people10.service.ReservationService;

@RestController
@RequestMapping("/api")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value = "/cutomer", method = RequestMethod.POST)
	public Reservation addReservation(@RequestBody Reservation reservation) {
		reservationService.addReservation(reservation);
		return reservation;
		
	}
	@RequestMapping(value = "/cutomer/{id}", method = RequestMethod.GET)
	public Optional<Reservation> getReservation(@PathVariable Long id) {
		
		return reservationService.getReservation(id);
		
	}
	

}
