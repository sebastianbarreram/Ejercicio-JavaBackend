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

    public Mono<Team> createTeam(Team team) throws IllegalAccessException {
        if (team.getTeamCode().length() <= 3 && team.getListCyclists().size()<=8) {
            return this.teamRepository.save(team);
        }
        if (team.getListCyclists().size()>8){
            throw new IllegalAccessException("El equipo ya ha alcanzado el número máximo de integrantes");
        }
         throw new IllegalAccessException("El código del equipo debe tener máximo 3 caracteres");
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
