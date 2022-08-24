package com.sofka.JavaBackend.service;

import com.sofka.JavaBackend.model.Cyclist;
import com.sofka.JavaBackend.model.Team;
import com.sofka.JavaBackend.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {
    @Mock
    TeamRepository teamRepository;

    @InjectMocks
    TeamService teamService;

    @Test
    void createTeam() {
        List<Cyclist> list =List.of(new Cyclist());
        Team team = new Team("1", "Tapitas", "123", "Colombia",list);

        when(teamRepository.save(Mockito.any(Team.class))).thenReturn(Mono.just(team));

        StepVerifier.create(teamService.createTeam(team))
                .expectNext(team)
                .expectComplete()
                .verify();

    }

    @Test
    void getAllTeams() {
    }

    @Test
    void findTeamById() {
    }

    @Test
    void deleteTeam() {
    }

    @Test
    void findTeamByCountry() {
    }
}