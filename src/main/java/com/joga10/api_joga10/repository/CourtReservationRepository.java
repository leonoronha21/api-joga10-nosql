package com.joga10.api_joga10.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joga10.api_joga10.model.CourtReservation;

@Repository
public interface CourtReservationRepository extends MongoRepository<CourtReservation, String> {
}
