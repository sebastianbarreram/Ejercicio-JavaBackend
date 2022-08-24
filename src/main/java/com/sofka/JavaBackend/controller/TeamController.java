package com.sofka.JavaBackend.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.sofka.JavaBackend.model.Cyclist;
import com.sofka.JavaBackend.model.Team;
import com.sofka.JavaBackend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    Logger logger = Logger.getLogger(TeamController.class.getName());

    @PostMapping
    public ResponseEntity<Team> add(@RequestBody Team team) {
        try {
            return ResponseEntity.ok(this.teamService.createTeam(team).toFuture().join());
        } catch (Exception e) {
            logger.info(e.getMessage());
            Team message = new Team();
            message.setId(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
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
    public ResponseEntity<Team> updateTeam(@PathVariable String id, @RequestBody Team newTeam) {
        try {
            Team team = this.teamService.findTeamById(id).toFuture().join();
            team.setName(newTeam.getName());
            team.setTeamCode(newTeam.getTeamCode());
            team.setCountry(newTeam.getCountry());
            team.setListCyclists(newTeam.getListCyclists());
            return  ResponseEntity.ok(this.teamService.createTeam(team).toFuture().join());
        } catch (Exception e) {
            Team message = new Team();
            message.setId(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }

    @GetMapping(value = "/byCountry/{country}")
    public Flux<Team> getTeamByCountry(@PathVariable String country) {
        return this.teamService.findTeamByCountry(country);
    }

    @GetMapping(value = "/cyclists/{id}")
    public Flux<Cyclist> getCyclistLits(@PathVariable String id) {
        return Flux.fromIterable(this.teamService.findTeamById(id).toFuture().join().getListCyclists());
    }

    @PutMapping(value = "/addCyclist/{team}")
    public Mono<Team> addCyclistToTeam(@RequestParam(name = "team") String teamCode) {
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
