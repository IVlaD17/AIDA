package com.example.aida.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Country implements Serializable {
    private String id;
    private String name;
    private ArrayList<City> cities;

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
        cities = new ArrayList<>();
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

    public ArrayList<City> getCities() {
        return cities;
    }
    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() { return name; }
}
