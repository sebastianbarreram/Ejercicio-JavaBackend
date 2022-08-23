package com.sofka.JavaBackend.controller;

import com.sofka.JavaBackend.model.Team;
import com.sofka.JavaBackend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    Logger logger = Logger.getLogger(TeamController.class.getName());

//    @PostMapping
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public Mono<Team> add(@RequestBody Team team) {
////        logger.info("Va entrando al metodo");
//        return this.teamService.createTeam(team)
//                .onErrorResume(err -> {
//                    logger.info(err.getMessage());
//                    return Mono.empty();
//                });
//    }

    @PostMapping
    public ResponseEntity<Team> add(@RequestBody Team team) {
        try {
            return ResponseEntity.ok(this.teamService.createTeam(team).toFuture().join());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public Flux<Team> getAll() {
        return this.teamService.getAllTeams();
    }

    @GetMapping(value = "/{id}")
    public Mono<Team> getTeamById(@PathVariable String id) {
        return this.teamService.findTeamById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> deleteTeam(@PathVariable String id) {
        return this.teamService.deleteTeam(id);
    }

    @PutMapping(value = "/{id}")
    public Mono<Team> updateTeam(@PathVariable String id, @RequestBody Team newTeam) {
        Team team = this.teamService.findTeamById(id).toFuture().join();
        team.setName(newTeam.getName());
        team.setTeam_code(newTeam.getTeam_code());
        team.setCountry(newTeam.getCountry());
        return this.teamService.createTeam(team);
    }

    @GetMapping(value = "/ByCountry/{country}")
    public Flux<Team> getTeamByCountry(@PathVariable String country){
        return this.teamService.findTeamByCountry(country);
    }
}
