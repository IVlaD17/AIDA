package com.example.aida.models;

public class Meal {

    private int id;
    private Food foodItem;
    private int foodAmount;

    public Meal(){
        this.foodItem = new Food();
        this.foodAmount = 0;
    }

    public Meal(Food foodItem, int foodAmount) {
        this.foodItem = foodItem;
        this.foodAmount = foodAmount;
    }

    public Meal(int id, Food foodItem, int foodAmount) {
        this.id = id;
        this.foodItem = foodItem;
        this.foodAmount = foodAmount;
    }

    public int getId() { return id; }

    public Food getFoodItem() { return foodItem; }
    public void setFoodItem(Food foodItem) { this.foodItem = foodItem; }

    public int getFoodAmount() { return foodAmount; }
    public void setFoodAmount(int foodAmount) { this.foodAmount = foodAmount; }
}
