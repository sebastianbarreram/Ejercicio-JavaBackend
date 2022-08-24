package com.sofka.JavaBackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "team")
public class Team {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String teamCode;
    private String country;
    private List<Cyclist> listCyclists;
}
