package com.example.aida.models.journalModels;

import com.example.aida.models.dateTimeModels.VDate;
import com.example.aida.models.dateTimeModels.VTime;
import com.example.aida.utility.Constants;

import java.util.HashMap;
import java.util.Map;

public class JEntry {
    // Meta Fields
    private String id;
    private String userID;

    // Date&Time Fields
    private VDate date;
    private VTime time;

    // Core Values Fields
    private float glycaemia;
    private float carbs;

    // Medication Fields
    private Medication medication1;
    private Medication medication2;

    // Details Fields
    private Sleep sleep;
    private Activity activity;

    // Default Constructor
    public JEntry(){
        id = "NoID";
        userID = "NoUserID";

        date = Constants.ZERO_DATE;
        time = Constants.ZERO_TIME;

        glycaemia = 0;
        carbs = 0;

        medication1 = new Medication();
        medication2 = new Medication();
        sleep = new Sleep();
        activity = new Activity();
    }

    // Generic Constructor
    public JEntry(String id, String userID, VDate date, VTime time, int glycaemia, int carbs, Medication medication1, Medication medication2, Sleep sleep, Activity activity) {
        this.id = id;
        this.userID = userID;

        this.date = date;
        this.time = time;

        this.glycaemia = glycaemia;
        this.carbs = carbs;

        this.medication1 = medication1;
        this.medication2 = medication2;

        this.sleep = sleep;
        this.activity = activity;
    }

    // Meta Accessors
    public String getId() { return id; }

    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    // Date&Time Accessors
    public VDate getDate() { return date; }
    public void setDate(VDate date) { this.date = date; }

    public VTime getTime() { return time; }
    public void setTime(VTime time) { this.time = time; }

    // Core Values Accessors
    public float getGlycaemia() { return glycaemia; }
    public void setGlycaemia(float glycaemia) { this.glycaemia = glycaemia; }

    public float getCarbs() { return carbs; }
    public void setCarbs(float carbs) { this.carbs = carbs; }

    // Medication Accessors
    public Medication getMedication1() { return medication1; }
    public void setMedication1(Medication medication) { medication1 = medication; }

    public Medication getMedication2() { return medication2; }
    public void setMedication2(Medication medication) { medication2 = medication; }

    // Details Accessors
    public Sleep getSleep() { return sleep; }
    public void setSleep(Sleep sleep) { this.sleep = sleep; }

    public Activity getActivity() { return activity; }
    public void setActivity(Activity activity) { this.activity = activity; }

    @Override
    public String toString() {
        return "Glucose Level: " + glycaemia + '\n' +
                "Carbohydrates: " + carbs + '\n' +
                medication1.toString() + '\n' +
                medication2.toString() + '\n' +
                sleep.toString() + '\n' +
                activity.toString();
    }

    // Database Object Generator
    public Map<String, Object> toDBOject(){
        Map<String, Object> entry = new HashMap<>();

        entry.put("userID", userID);

        entry.put("date", date.toString());
        entry.put("time", time.toString());

        entry.put("glucose", glycaemia);
        entry.put("carbohydrates", carbs);

        entry.put("primaryMedicationName", medication1.getName());
        entry.put("primaryMedicationQuantity", medication1.getQuantity());

        entry.put("secondaryMedicationName", medication2.getName());
        entry.put("secondaryMedicationQuantity", medication2.getQuantity());

        entry.put("hasSlept", sleep.getHasSlept().toString());
        entry.put("sleepStart", sleep.getStart().toString());
        entry.put("sleepEnd", sleep.getEnd().toString());

        entry.put("physicalActivityType", activity.getType().toString());
        entry.put("physicalActivityStart", activity.getStart().toString());
        entry.put("physicalActivityEnd", activity.getEnd().toString());


        return entry;
    }
}
