
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

import com.joga10.api_joga10.model.Team;
import com.joga10.api_joga10.repository.TeamRepository;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Team> getTeamById(@PathVariable String id) {
        return teamRepository.findById(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable String id, @RequestBody Team team) {
        team.setId(id);
        return teamRepository.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable String id) {
        teamRepository.deleteById(id);
    }
}
