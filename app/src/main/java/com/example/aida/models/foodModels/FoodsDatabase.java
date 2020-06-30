package com.example.aida.models.foodModels;

import java.util.ArrayList;

public class FoodsDatabase {
    private ArrayList<Food> foods;

    // Default Constructor
    public FoodsDatabase(){
        foods = new ArrayList<>();
    }

    // Generic Constructor
    public FoodsDatabase(ArrayList<Food> foods){
        this.foods = foods;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }
    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public boolean createFoods(Food food) {
        if(foods.contains(food)) {
            return false;
        } else {
            foods.add(food);
        }

        return true;
    }
    public boolean updateFood(Food food) {
        if(!foods.contains(food)) {
            return false;
        } else {
            foods.set(foods.indexOf(food), food);
        }

        return true;
    }
    public boolean deleteFood(Food food) {
        if(!foods.contains(food)) {
            return false;
        } else {
            foods.remove(food);
        }

        return true;
    }
}
