package com.sofka.JavaBackend.service;

import com.sofka.JavaBackend.model.Team;
import com.sofka.JavaBackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Mono<Team> createTeam(Team team) {

        return this.teamRepository.save(team);
    }

    public Flux<Team> getAllTeams() {
        return this.teamRepository.findAll();
    }

    public Mono<Team> findTeamById(String id) {
        return this.teamRepository.findById(id);
    }

    public Mono<Void> deleteTeam(String id) {
        return this.teamRepository.deleteById(id);
    }

    public Flux<Team> findTeamByCountry(String country) {
        return this.teamRepository.findAllByCountry(country);
    }
}
