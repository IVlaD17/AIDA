package com.example.aida.utility;

import com.example.aida.models.userModels.City;
import com.example.aida.models.userModels.Country;
import com.example.aida.models.foodModels.Food;
import com.example.aida.models.journalModels.JournalEntry;
import com.example.aida.models.journalModels.Medication;
import com.example.aida.models.journalModels.Activity;
import com.example.aida.models.journalModels.Sleep;
import com.example.aida.models.userModels.User;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;

public class Methods {
    public static boolean isNullOrWhiteSpace(String string){ return string == null || string.isEmpty() || string.trim().isEmpty(); }

    public static Country findCountryById(String value, ArrayList<Country> countries){
        for(Country country : countries){
            if(country.getId().equals(value)){
                return country;
            }
        }
        return null;
    }
    public static Country findCountryByName(String value, ArrayList<Country> countries){
        for(Country country : countries){
            if(country.getName().equals(value)){
                return country;
            }
        }
        return null;
    }

    public static City findCityById(String value, ArrayList<City> cities){
        for(City city : cities){
            if(city.getId().equals(value)){
                return city;
            }
        }
        return null;
    }
    public static Food findFoodItemByName(String value, ArrayList<Food> foodItems){
        for(Food food : foodItems){
            if(food.getName().equals(value)){
                return food;
            }
        }
        return null;
    }

    public static City findCityByName(String value, ArrayList<City> cities){
        for(City city : cities){
            if(city.getName().equals(value)){
                return city;
            }
        }
        return null;
    }

    public static User convertDBDataToUser(DocumentSnapshot document, ArrayList<Country> countries){
        String dbID = document.getId();
        String dbEmail = document.getData().get("email").toString();
        String dbPass = document.getData().get("password").toString();
        String dbAddress = document.getData().get("address").toString();
        String dbCity = document.getData().get("city").toString();
        String dbCountry = document.getData().get("country").toString();
        String dbDiabetesType = document.getData().get("diabetesType").toString();
        String dbFirstName = document.getData().get("firstName").toString();
        String dbLastName = document.getData().get("lastName").toString();
        String dbTelephone = document.getData().get("telephone").toString();

        return new User(dbID, dbEmail, dbPass, dbFirstName, dbLastName, dbTelephone, dbAddress, dbCountry, dbCity, dbDiabetesType, countries);
    }
    public static Food convertDBDataToFoodItem(DocumentSnapshot document){
        String dbID = document.getId();
        String dbName = document.getData().get("name").toString();
        String dbCategory = document.getData().get("category").toString();
        float dbCarbohydrates = Float.valueOf(document.getData().get("carbohydrates").toString());
        float dbSugars = Float.valueOf(document.getData().get("sugars").toString());
        float dbFat = Float.valueOf(document.getData().get("fat").toString());
        float dbSaturates = Float.valueOf(document.getData().get("saturates").toString());
        float dbEnergy = Float.valueOf(document.getData().get("energy").toString());
        float dbFiber = Float.valueOf(document.getData().get("fiber").toString());
        float dbProtein = Float.valueOf(document.getData().get("protein").toString());
        float dbSalt = Float.valueOf(document.getData().get("salt").toString());

        return new Food(dbID, dbName, dbCategory, dbCarbohydrates, dbSugars, dbFat, dbSaturates, dbEnergy, dbFiber, dbProtein, dbSalt);
    }
    public static JournalEntry convertDBDataToJournalEntry(DocumentSnapshot document){
        String dbID = document.getId();
        int dbCarbohydrates = Integer.valueOf(document.getData().get("carbohydrates").toString());
        String dbDate = document.getData().get("date").toString();
        int dbGlucose = Integer.valueOf(document.getData().get("glucose").toString());
        Boolean dbHasSlept = Boolean.valueOf(document.getData().get("hasSlept").toString());
        String dbPhysicalActivityEnd = document.getData().get("physicalActivityEnd").toString();
        String dbPhysicalActivityStart = document.getData().get("physicalActivityStart").toString();
        String dbPhysicalActivityType = document.getData().get("physicalActivityType").toString();
        String dbPrimaryMedicationName = document.getData().get("primaryMedicationName").toString();
        float dbPrimaryMedicationQuantity = Float.valueOf(document.getData().get("primaryMedicationQuantity").toString());
        String dbSecondaryMedicationName = document.getData().get("secondaryMedicationName").toString();
        float dbSecondaryMedicationQuantity = Float.valueOf(document.getData().get("secondaryMedicationQuantity").toString());
        String dbSleepEnd = document.getData().get("sleepEnd").toString();
        String dbSleepStart = document.getData().get("sleepStart").toString();
        String dbTime = document.getData().get("time").toString();

        MDate date = new MDate(dbDate);
        MTime time = new MTime(dbTime);

        MTime sleepStart = new MTime(dbSleepStart);
        MTime sleepEnd = new MTime(dbSleepEnd);
        Sleep sleep = new Sleep(dbHasSlept, sleepStart, sleepEnd);

        MTime activityStart = new MTime(dbPhysicalActivityStart);
        MTime activityEnd = new MTime(dbPhysicalActivityEnd);
        Activity physicalActivity = new Activity(dbPhysicalActivityType, activityStart, activityEnd);

        Medication primaryMedication = new Medication(dbPrimaryMedicationName, dbPrimaryMedicationQuantity);
        Medication secondaryMedication = new Medication(dbSecondaryMedicationName, dbSecondaryMedicationQuantity);

        return new JournalEntry(dbID, date, time, dbGlucose, dbCarbohydrates, primaryMedication, secondaryMedication, sleep, physicalActivity);
    }
}
