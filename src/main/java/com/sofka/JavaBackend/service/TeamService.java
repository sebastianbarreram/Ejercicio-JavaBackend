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
    TeamRepository teamRepository;

    public Mono<Team> createTeam(Team team){
        return teamRepository.save(team);
    }

    public Flux<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Mono<Team> findTeamById(String id){
        return teamRepository.findById(id);
    }

    public Mono<Void> deleteTeam(String id){
        return teamRepository.deleteById(id);
    }
}
