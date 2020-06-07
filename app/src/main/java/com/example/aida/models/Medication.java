package com.example.aida.models;

public class Medication {
    private String name;
    private float quantity;

    public Medication(){
        this.name = "None";
        this.quantity = 0;
    }

    public Medication(String name) {
        this.name = name;
    }

    public Medication(String name, float quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public float getQuantity() { return quantity; }
    public void setQuantity(float quantity) { this.quantity = quantity; }

    @Override
    public String toString() { return name + ": " + quantity; }
}


