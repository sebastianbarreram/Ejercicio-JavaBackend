package com.sofka.JavaBackend.controller;

import com.sofka.JavaBackend.model.Team;
import com.sofka.JavaBackend.service.TeamService;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    Logger logger = Logger.getLogger(TeamController.class.getName());

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Team> add(@RequestBody Team team) {
//        logger.info("Va entrando al metodo");
        return teamService.createTeam(team)
                .onErrorResume(err -> {
                    logger.info(err.getMessage());
                    return Mono.empty();
                });
    }

    @GetMapping
    public Flux<Team> getAll() {
        return teamService.getAllTeams();
    }
}
