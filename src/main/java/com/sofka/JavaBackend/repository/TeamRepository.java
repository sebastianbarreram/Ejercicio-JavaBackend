package com.sofka.JavaBackend.repository;

import com.sofka.JavaBackend.model.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TeamRepository extends ReactiveMongoRepository<Team,String> {
}
