package com.sofka.JavaBackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cyclist")
public class Cyclist {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String cyclistNumber;
    private String team;
    private String nationality;
}
