package com.joga10.api_joga10.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joga10.api_joga10.model.PlayerRating;
import com.joga10.api_joga10.repository.PlayerRatingRepository;

@RestController
@RequestMapping("/api/player-ratings")
public class PlayerRatingController {
    @Autowired
    private PlayerRatingRepository ratingRepository;

    @GetMapping
    public List<PlayerRating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @GetMapping("/player/{playerId}")
    public List<PlayerRating> getRatingsByPlayer(@PathVariable String playerId) {
        return ratingRepository.findByPlayerId(playerId);
    }

    @GetMapping("/{id}")
    public Optional<PlayerRating> getRatingById(@PathVariable String id) {
        return ratingRepository.findById(id);
    }


    @PostMapping
    public PlayerRating createRating(@RequestBody PlayerRating rating) {
        // Impede autoavaliação
        if (rating.getPlayerId() != null && rating.getPlayerId().equals(rating.getReviewerId())) {
            throw new IllegalArgumentException("Autoavaliação não permitida.");
        }
        return ratingRepository.save(rating);
    }
    // Endpoint para média de notas de um jogador
    @GetMapping("/player/{playerId}/average")
    public double getAverageRating(@PathVariable String playerId) {
        List<PlayerRating> ratings = ratingRepository.findByPlayerId(playerId);
        if (ratings.isEmpty()) return 0.0;
        double sum = ratings.stream().mapToInt(PlayerRating::getRating).sum();
        return sum / ratings.size();
    }

    @PutMapping("/{id}")
    public PlayerRating updateRating(@PathVariable String id, @RequestBody PlayerRating rating) {
        rating.setId(id);
        return ratingRepository.save(rating);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable String id) {
        ratingRepository.deleteById(id);
    }
}
