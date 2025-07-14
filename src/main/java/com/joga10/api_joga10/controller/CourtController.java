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

import com.joga10.api_joga10.model.Court;
import com.joga10.api_joga10.repository.CourtRepository;

@RestController
@RequestMapping("/api/courts")
public class CourtController {
    @Autowired
    private CourtRepository courtRepository;


    @GetMapping
    public List<Court> getAllCourts() {
        return courtRepository.findAll();
    }

    @GetMapping("/establishment/{establishmentId}")
    public List<Court> getCourtsByEstablishment(@PathVariable String establishmentId) {
        return courtRepository.findByEstablishmentId(establishmentId);
    }

    @GetMapping("/{id}")
    public Optional<Court> getCourtById(@PathVariable String id) {
        return courtRepository.findById(id);
    }

    @PostMapping
    public Court createCourt(@RequestBody Court court) {
        return courtRepository.save(court);
    }

    @PutMapping("/{id}")
    public Court updateCourt(@PathVariable String id, @RequestBody Court court) {
        court.setId(id);
        return courtRepository.save(court);
    }

    @DeleteMapping("/{id}")
    public void deleteCourt(@PathVariable String id) {
        courtRepository.deleteById(id);
    }
}
