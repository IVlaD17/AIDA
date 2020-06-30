package com.example.aida.models.userModels;

import java.io.Serializable;

public class City implements Serializable {
    private String id;
    private String name;
    private String countryID;

    public City(String id, String name, String countryID) {
        this.id = id;
        this.name = name;
        this.countryID = countryID;
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

    public String getCountryID() {
        return countryID;
    }
    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    @Override
    public String toString() { return name; }
}
