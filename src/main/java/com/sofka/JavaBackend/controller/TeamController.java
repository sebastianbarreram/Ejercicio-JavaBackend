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
    @GetMapping(value = "/{id}")
    public Mono<Team> getTeamById(@PathVariable String id){
        return teamService.findTeamById(id)
//                .onErrorResume(err -> {
//                    logger.info(err.getMessage());
//                    return Mono.empty();
//                })
                ;
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> deleteTeam(@PathVariable String id){
        return teamService.deleteTeam(id);
    }

    @PutMapping(value = "/{id}")
    public Mono<Team> updateTeam(@PathVariable String id, @RequestBody Team newTeam){
        Team team=teamService.findTeamById(id).toFuture().join();
        team.setName(newTeam.getName());
        team.setTeam_code(newTeam.getTeam_code());
        team.setCountry(newTeam.getCountry());
        return teamService.createTeam(team);
    }
}
