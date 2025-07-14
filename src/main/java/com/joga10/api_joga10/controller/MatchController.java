package com.joga10.api_joga10.controller;

import com.joga10.api_joga10.model.Match;
import com.joga10.api_joga10.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    @Autowired
    private MatchRepository matchRepository;

    @GetMapping
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Match> getMatchById(@PathVariable String id) {
        return matchRepository.findById(id);
    }

    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchRepository.save(match);
    }

    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable String id, @RequestBody Match match) {
        match.setId(id);
        return matchRepository.save(match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable String id) {
        matchRepository.deleteById(id);
    }
}
