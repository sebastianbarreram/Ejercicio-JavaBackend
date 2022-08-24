package com.sofka.JavaBackend.service;

import com.sofka.JavaBackend.model.Cyclist;
import com.sofka.JavaBackend.repository.CyclistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CyclistService {
    @Autowired
    private CyclistRepository cyclistRepository;

    public Mono<Cyclist> createCyclist(Cyclist cyclist) throws IllegalAccessException {
        if (cyclist.getCyclistNumber().length()<=3){
            return this.cyclistRepository.save(cyclist);
        }
        throw new IllegalAccessException("El número de competidor debe tener máximo 3 caracteres");

    }

    public Flux<Cyclist> getAllCyclists() {
        return this.cyclistRepository.findAll();
    }

    public Mono<Cyclist> findCyclistById(String id) {
        return this.cyclistRepository.findById(id);
    }

    public Mono<Void> deleteCyclist(String id) {
        return this.cyclistRepository.deleteById(id);
    }

    public Flux<Cyclist> findCyclistByNationality(String nationality) {
        return this.cyclistRepository.findAllByNationality(nationality);
    }

    public Flux<Cyclist> findCyclistByTeamCode(String teamCode) {
        return this.cyclistRepository.findAllByTeamCode(teamCode);
    }
}
