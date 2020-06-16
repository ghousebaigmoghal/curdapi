package com.people10.repository;

import org.springframework.data.repository.CrudRepository;

import com.people10.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
