package com.example.aida.models;

import java.io.Serializable;

public class Food implements Serializable {
    public enum FoodCategories{
        NONE { public String toString() {return "None";} },
        CEREALS { public String toString() {return "Cereals";} },
        VEGETABLES { public String toString() {return "Vegetables";} },
        BEANS { public String toString() {return "Beans";} },
        FRUITS { public String toString() {return "Fruits";} },
        DAIRY { public String toString() {return "Dairy";} },
        MEATS { public String toString() {return "Meats";} },
        FAST_FOODS { public String toString() {return "Fast Foods";} },
        SNACKS { public String toString() {return "Snacks";} }
    }

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

    public Food(){
        id = "";
        name = "None";
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

    // Constructor designed to be used when pulling data from the database
    public Food(String id, String name, String category, float carbohydrates, float sugars, float fat, float saturates, float energy, float fiber,
                    float protein, float salt) {
        if(category.equals("None"))
            this.category = FoodCategories.NONE;
        if(category.equals("Cereals"))
            this.category = FoodCategories.CEREALS;
        if(category.equals("Vegetables"))
            this.category = FoodCategories.VEGETABLES;
        if(category.equals("Beans"))
            this.category = FoodCategories.BEANS;
        if(category.equals("Fruits"))
            this.category = FoodCategories.FRUITS;
        if(category.equals("Dairy"))
            this.category = FoodCategories.DAIRY;
        if(category.equals("Meats"))
            this.category = FoodCategories.MEATS;
        if(category.equals("Fast Foods"))
            this.category = FoodCategories.FAST_FOODS;
        if(category.equals("Snacks"))
            this.category = FoodCategories.SNACKS;

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

    // Generic constructor
    public Food(String name, FoodCategories category, float carbohydrates, float sugars, float fat, float saturates, float energy, float fiber,
                    float protein, float salt) {
        this.id = "";
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

    public Food(String id, String name, FoodCategories category, float carbohydrates, float sugars, float fat, float saturates, float energy,
                    float fiber, float protein, float salt) {
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

    public String leftColumn(){
        return "Carbohydrates: " + carbohydrates + "g\n" +
                "Fat: " + fat + "g\n" +
                "Energy: " + energy + "kcal\n" +
                "Protein: " + protein + "g\n";
    }

    public String rightColumn(){
        return "of which sugars: " + sugars + "g\n" +
                "of which saturates: " + saturates + "g\n" +
                "Fiber: " + fiber + "g\n" +
                "Salt: " + salt + "g";
    }
}
