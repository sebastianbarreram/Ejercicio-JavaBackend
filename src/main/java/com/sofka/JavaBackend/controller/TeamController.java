package com.sofka.JavaBackend.controller;

import com.sofka.JavaBackend.model.Team;
import com.sofka.JavaBackend.service.TeamService;
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

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Team> add(@RequestBody Team team){
        return teamService.createTeam(team);
    }

    @GetMapping
    public Flux<Team> getAll(){
        return teamService.getAllTeams();
    }
}
