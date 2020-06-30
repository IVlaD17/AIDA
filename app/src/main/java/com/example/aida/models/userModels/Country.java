package com.example.aida.models.userModels;

import java.util.ArrayList;

public class Country {
    private String id;
    private String name;
    private ArrayList<City> cities;

    // Default Constructor
    public Country(){
        this.id = "NoID";
        this.name = "NoName";
        this.cities = new ArrayList<>();
    }

    // No Cities Constructor
    public Country(String id, String name){
        this.id = id;
        this.name = name;
        this.cities = new ArrayList<>();
    }

    // Generic Constructor
    public Country(String id, String name, ArrayList<City> cities){
        this.id = id;
        this.name = name;
        this.cities = cities;
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
