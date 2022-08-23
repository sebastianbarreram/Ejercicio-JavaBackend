package com.sofka.JavaBackend.repository;

import com.sofka.JavaBackend.model.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CyclistRepository extends ReactiveMongoRepository<Cyclist,String> {
    Flux<Cyclist> findAllByNationality(String nationality);
}
