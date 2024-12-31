package com.wecp.progressive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.repository.cdi.Eager;
@Entity
public class Team implements Comparable<Team> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;
    private String team_name;
    private String location;
    private String owner_name;
    private int establishment_year;
    
    public Team(int team_id, String team_name, String location, String owner_name, int establishment_year) {
        this.team_id = team_id;
        this.team_name = team_name;
        this.location = location;
        this.owner_name = owner_name;
        this.establishment_year = establishment_year;
    }
    public Team() {
        //TODO Auto-generated constructor stub
    }
    public int getTeam_id() {
        return team_id;
    }
    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
    public String getTeam_name() {
        return team_name;
    }
    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getOwner_name() {
        return owner_name;
    }
    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }
    public int getEstablishment_year() {
        return establishment_year;
    }
    public void setEstablishment_year(int establishment_year) {
        this.establishment_year = establishment_year;
    }
    @Override
    public int compareTo(Team otherTeam){
        return  this.getTeam_name().compareTo(otherTeam.getTeam_name());
        //return String.compare(this.getTeam_name(),otherTeam.getTeam_name());
    }
    
}