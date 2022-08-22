package com.sofka.JavaBackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Cyclist {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String clyclist_number;
    private String team;
    private String country;

    public Cyclist(String name, String clyclist_number, String team, String country) {
        this.name = name;
        this.clyclist_number = clyclist_number;
        this.team = team;
        this.country = country;
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

    public String getClyclist_number() {
        return clyclist_number;
    }

    public void setClyclist_number(String clyclist_number) {
        this.clyclist_number = clyclist_number;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
