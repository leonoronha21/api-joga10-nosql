package com.joga10.api_joga10.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joga10.api_joga10.model.Court;

@Repository
public interface CourtRepository extends MongoRepository<Court, String> {
    java.util.List<Court> findByEstablishmentId(String establishmentId);
}
