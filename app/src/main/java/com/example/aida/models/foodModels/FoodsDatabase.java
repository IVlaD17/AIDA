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

    public boolean createFood(Food food) {
        for(int fI = 0; fI < foods.size(); fI++) {
            if(food.getId().equals(foods.get(fI).getId())) {
                return false;
            }
        }

        foods.add(food);
        return true;
    }
    public boolean updateFood(Food food) {
        for(int fI = 0; fI < foods.size(); fI++) {
            if(food.getId().equals(foods.get(fI).getId())) {
                foods.set(fI, food);
                return true;
            }
        }

        return false;
    }
    public boolean deleteFood(Food food) {
        for(int fI = 0; fI < foods.size(); fI++) {
            if(food.getId().equals(foods.get(fI).getId())) {
                foods.remove(food);
                return true;
            }
        }

        return false;
    }
}
