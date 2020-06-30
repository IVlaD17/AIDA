package com.example.aida.models.mealModels;

import com.example.aida.models.foodModels.Food;

public class Meal {

    private Food item;
    private float quantity;

    // Default Constructor
    public Meal(){
        this.item = new Food();
        this.quantity = 0;
    }

    // Generic Constructor
    public Meal(Food item, float quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Food getItem() { return item; }
    public void setItem(Food item) { this.item = item; }

    public float getQuantity() { return quantity; }
    public void setQuantity(float quantity) { this.quantity = quantity; }

    public float calculateCarbs(){
        return item.getCarbohydrates() / 100 * quantity;
    }
    public float calculateSugars() {
        return item.getSugars() / 100 * quantity;
    }
    public float calculateFat() {
        return item.getFat() / 100 * quantity;
    }
    public float calculateSaturates() {
        return item.getSaturates() / 100 * quantity;
    }
    public float calculateEnergy() {
        return item.getEnergy() / 100 * quantity;
    }
    public float calculateFiber() {
        return item.getFiber() / 100 * quantity;
    }
    public float calculateProtein() {
        return item.getProtein() / 100 * quantity;
    }
    public float calculateSalt() {
        return item.getSalt() / 100 * quantity;
    }
}
