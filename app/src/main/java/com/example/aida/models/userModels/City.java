package com.example.aida.models.userModels;

import java.io.Serializable;

public class City implements Serializable {
    private String id;
    private String name;
    private Country country;

    // Default Constructor
    public City(){
        id = "NoID";
        name = "NoName";
        country = new Country();
    }

    // Generic Constructor
    public City(String id, String name, Country country){
        this.id = id;
        this.name = name;
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

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() { return name; }
}
