package com.example.aida.models;

public enum FoodCategories {
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
