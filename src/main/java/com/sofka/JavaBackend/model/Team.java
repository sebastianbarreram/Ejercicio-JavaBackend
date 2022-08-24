package com.sofka.JavaBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "team")
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String teamCode;
    private String country;
    private List<Cyclist> listCyclists;
}
