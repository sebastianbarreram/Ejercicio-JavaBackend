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
        if (team.getTeamCode().length() <= 3) {
            return this.teamRepository.save(team);
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

    //TODO:Agregar ciclista al equipo
    //TODO: Un equipo de ciclismo estará conformado por un máximo de 8 corredores.
}
