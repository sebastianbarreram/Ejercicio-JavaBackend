package com.sofka.JavaBackend.controller;

import com.sofka.JavaBackend.model.Cyclist;
import com.sofka.JavaBackend.model.Team;
import com.sofka.JavaBackend.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/cyclist")
public class CyclistController {
    @Autowired
    private CyclistService cyclistService;

    Logger logger = Logger.getLogger(CyclistController.class.getName());

    @PostMapping
    public ResponseEntity<Cyclist> add(@RequestBody Cyclist cyclist) {
        try {
            return ResponseEntity.ok(this.cyclistService.createCyclist(cyclist).toFuture().join());
        } catch (Exception e) {
            logger.info(e.getMessage());
            Cyclist message = new Cyclist();
            message.setId(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }

    @GetMapping
    public Flux<Cyclist> getAll() {
        return this.cyclistService.getAllCyclists();
    }

    @GetMapping(value = "/{id}")
    public Mono<Cyclist> getCyclistById(@PathVariable String id) {
        return this.cyclistService.findCyclistById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> deleteCyclist(@PathVariable String id) {
        return this.cyclistService.deleteCyclist(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cyclist> updateCyclist(@PathVariable String id, @RequestBody Cyclist newCyclist) {
        try {
            Cyclist cyclist = this.cyclistService.findCyclistById(id).toFuture().join();
            cyclist.setName(newCyclist.getName());
            cyclist.setCyclistNumber(newCyclist.getCyclistNumber());
            cyclist.setTeamCode(newCyclist.getTeamCode());
            cyclist.setNationality(newCyclist.getNationality());
            return ResponseEntity.ok(this.cyclistService.createCyclist(cyclist).toFuture().join());
        }catch (Exception e){
            Cyclist message = new Cyclist();
            message.setId(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }

    @GetMapping(value = "/byNationality/{nationality}")
    public Flux<Cyclist> getCyclistByNationality(@PathVariable String nationality){
        return this.cyclistService.findCyclistByNationality(nationality);
    }

    @GetMapping(value = "/byTeamCode/{teamCode}")
    public Flux<Cyclist> getCyclistByTeamCode(@PathVariable String teamCode){
        return this.cyclistService.findCyclistByTeamCode(teamCode);
    }
}
