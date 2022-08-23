package com.sofka.JavaBackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cyclist")
public class Cyclist {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String cyclistNumber;
    private String team;
    private String nationality;

    public Cyclist(String name, String cyclistNumber, String team, String nationality) {
        this.name = name;
        this.cyclistNumber = cyclistNumber;
        this.team = team;
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClyclistNumber() {
        return cyclistNumber;
    }

    public void setClyclistNumber(String cyclistNumber) {
        this.cyclistNumber = cyclistNumber;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
