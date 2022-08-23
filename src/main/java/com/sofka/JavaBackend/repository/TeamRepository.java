package com.sofka.JavaBackend.repository;

import com.sofka.JavaBackend.model.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TeamRepository extends ReactiveMongoRepository<Team,String> {
    Flux<Team> findAllByCountry (String value);
}
