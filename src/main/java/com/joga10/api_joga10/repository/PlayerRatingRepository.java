package com.joga10.api_joga10.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joga10.api_joga10.model.PlayerRating;

@Repository
public interface PlayerRatingRepository extends MongoRepository<PlayerRating, String> {
    List<PlayerRating> findByPlayerId(String playerId);
}
