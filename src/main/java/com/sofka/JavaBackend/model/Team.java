package com.sofka.JavaBackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "team")
public class Team {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String teamCode;
    private String country;
    private List<Cyclist> listCyclists;

    public Team(String name, String teamCode, String country, List<Cyclist> listCyclists) {
        this.name = name;
        this.teamCode = teamCode;
        this.country = country;
        this.listCyclists = listCyclists;
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

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String team_code) {
        this.teamCode = team_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Cyclist> getListCyclists() {
        return listCyclists;
    }

    public void setListCyclists(List<Cyclist> listCyclists) {
        this.listCyclists = listCyclists;
    }
}
