package com.joga10.api_joga10.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joga10.api_joga10.model.Establishment;

@Repository
public interface EstablishmentRepository extends MongoRepository<Establishment, String> {
}
