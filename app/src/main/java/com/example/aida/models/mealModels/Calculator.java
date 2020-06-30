package com.example.aida.models.mealModels;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Meal> meals;

    // Default Constructor
    public Calculator(){
        meals = new ArrayList<>();
    }

    // Generic Constructor
    public Calculator(ArrayList<Meal> meals){
        this.meals = meals;
    }

    public float calculateCarbs(){
        float carbs = 0;

        for (Meal meal : meals)
            carbs += meal.calculateCarbs();

        return carbs;
    }
    public float calculateSugars() {
        float sugars = 0;

        for (Meal meal : meals)
            sugars += meal.calculateSugars();

        return sugars;
    }
    public float calculateFat() {
        float fat = 0;

        for (Meal meal : meals)
            fat += meal.calculateFat();

        return fat;
    }
    public float calculateSaturates() {
        float saturates = 0;

        for (Meal meal : meals)
            saturates += meal.calculateSaturates();

        return saturates;
    }
    public float calculateEnergy() {
        float energy = 0;

        for (Meal meal : meals)
            energy += meal.calculateEnergy();

        return energy;
    }
    public float calculateFiber() {
        float fiber = 0;

        for (Meal meal : meals)
            fiber += meal.calculateFiber();

        return fiber;
    }
    public float calculateProtein() {
        float protein = 0;

        for (Meal meal : meals)
            protein += meal.calculateProtein();

        return protein;
    }
    public float calculateSalt() {
        float salt = 0;

        for (Meal meal : meals)
            salt += meal.calculateSalt();

        return salt;
    }

    public boolean createMeal(Meal meal) {
        if(meals.contains(meal)) {
            return false;
        } else {
            meals.add(meal);
        }

        return true;
    }
    public boolean updateMeal(Meal meal) {
        if(!meals.contains(meal)) {
            return false;
        } else {
            meals.set(meals.indexOf(meal), meal);
        }

        return true;
    }
    public boolean deleteMeal(Meal meal) {
        if(!meals.contains(meal)) {
            return false;
        } else {
            meals.remove(meal);
        }

        return true;
    }
}
