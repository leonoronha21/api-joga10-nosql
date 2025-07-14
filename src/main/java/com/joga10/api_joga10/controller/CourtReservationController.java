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

import com.joga10.api_joga10.model.CourtReservation;
import com.joga10.api_joga10.repository.CourtReservationRepository;

@RestController
@RequestMapping("/api/court-reservations")
public class CourtReservationController {
    @Autowired
    private CourtReservationRepository reservationRepository;

    @GetMapping
    public List<CourtReservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CourtReservation> getReservationById(@PathVariable String id) {
        return reservationRepository.findById(id);
    }

    @PostMapping
    public CourtReservation createReservation(@RequestBody CourtReservation reservation) {
        return reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public CourtReservation updateReservation(@PathVariable String id, @RequestBody CourtReservation reservation) {
        reservation.setId(id);
        return reservationRepository.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationRepository.deleteById(id);
    }
}
