package com.example.aida.models.foodModels;

import java.io.Serializable;

public class Food implements Serializable {
    private String id;
    private String name;
    private FoodCategories category;
    private float carbohydrates;
    private float sugars;
    private float fat;
    private float saturates;
    private float energy;
    private float fiber;
    private float protein;
    private float salt;

    // Default Constructor
    public Food(){
        id = "NoID";
        name = "NoName";
        category = FoodCategories.NONE;
        carbohydrates = 0;
        sugars = 0;
        fat = 0;
        saturates = 0;
        energy = 0;
        fiber = 0;
        protein = 0;
        salt = 0;
    }

    // Generic constructor
    public Food(String id, String name, FoodCategories category, float carbohydrates, float sugars, float fat, float saturates, float energy, float fiber, float protein, float salt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.carbohydrates = carbohydrates;
        this.sugars = sugars;
        this.fat = fat;
        this.saturates = saturates;
        this.energy = energy;
        this.fiber = fiber;
        this.protein = protein;
        this.salt = salt;
    }

    // FoodCategories String Parameter Constructor
    public Food(String id, String name, String category, float carbohydrates, float sugars, float fat, float saturates, float energy, float fiber, float protein, float salt) {
        switch (category){
            case "Cereals":
                this.category = FoodCategories.CEREALS;
            case "Vegetables":
                this.category = FoodCategories.VEGETABLES;
            case "Beans":
                this.category = FoodCategories.BEANS;
            case "Fruits":
                this.category = FoodCategories.FRUITS;
            case "Dairy":
                this.category = FoodCategories.DAIRY;
            case "Meats":
                this.category = FoodCategories.MEATS;
            case "Fast Foods":
                this.category = FoodCategories.FAST_FOODS;
            case "Snacks":
                this.category = FoodCategories.SNACKS;
            default:
                this.category = FoodCategories.NONE;
        }

        this.id = id;
        this.name = name;
        this.carbohydrates = carbohydrates;
        this.sugars = sugars;
        this.fat = fat;
        this.saturates = saturates;
        this.energy = energy;
        this.fiber = fiber;
        this.protein = protein;
        this.salt = salt;
    }

    public String getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public FoodCategories getCategory() { return category; }
    public void setCategory(FoodCategories category) { this.category = category; }

    public float getCarbohydrates() { return carbohydrates; }
    public void setCarbohydrates(float carbohydrates) { this.carbohydrates = carbohydrates; }

    public float getSugars() { return sugars; }
    public void setSugars(float sugars) { this.sugars = sugars; }

    public float getFat() { return fat; }
    public void setFat(float fat) { this.fat = fat; }

    public float getSaturates() { return saturates; }
    public void setSaturates(float saturates) { this.saturates = saturates; }

    public float getEnergy() { return energy; }
    public void setEnergy(float energy) { this.energy = energy; }

    public float getFiber() { return fiber; }
    public void setFiber(float fiber) { this.fiber = fiber; }

    public float getProtein() { return protein; }
    public void setProtein(float protein) { this.protein = protein; }

    public float getSalt() { return salt; }
    public void setSalt(float salt) { this.salt = salt; }

    @Override
    public String toString() {
        return name;
    }
}
