package com.people10.repository;

import org.springframework.data.repository.CrudRepository;

import com.people10.model.CustomerEntity;

public interface ReservationRepository extends CrudRepository<CustomerEntity, Long> {

}
