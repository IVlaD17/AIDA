package com.example.aida.models;

import com.example.aida.views.MainActivity;
import com.example.aida.utility.Constants;
import com.example.aida.utility.MDate;
import com.example.aida.utility.MTime;

import java.util.HashMap;
import java.util.Map;

public class JournalEntry {

    private String id;
    private MDate date;
    private MTime time;
    private int glucose;
    private int carbohydrates;
    private Medication primaryMedication;
    private Medication secondaryMedication;
    private Sleep sleep;
    private Activity physicalActivity;

    public JournalEntry(){
        date = Constants.ZERO_DATE;
        time = Constants.ZERO_TIME;
        glucose = 0;
        carbohydrates = 0;
        primaryMedication = new Medication();
        secondaryMedication = new Medication();
        sleep = new Sleep();
        physicalActivity = new Activity();
    }

    public JournalEntry(MDate date, MTime time, int glucose, int carbohydrates, Medication primaryMedication, Medication secondaryMedication,
                        Sleep sleep, Activity physicalActivity) {
        this.date = date;
        this.time = time;
        this.glucose = glucose;
        this.carbohydrates = carbohydrates;
        this.primaryMedication = primaryMedication;
        this.secondaryMedication = secondaryMedication;
        this.sleep = sleep;
        this.physicalActivity = physicalActivity;
    }

    public JournalEntry(String id, MDate date, MTime time, int glucose, int carbohydrates, Medication primaryMedication, Medication secondaryMedication,
                        Sleep sleep, Activity physicalActivity) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.glucose = glucose;
        this.carbohydrates = carbohydrates;
        this.primaryMedication = primaryMedication;
        this.secondaryMedication = secondaryMedication;
        this.sleep = sleep;
        this.physicalActivity = physicalActivity;
    }

    public String getId() { return id; }

    public MDate getDate() { return date; }
    public void setDate(MDate date) { this.date = date; }

    public MTime getTime() { return time; }
    public void setTime(MTime time) { this.time = time; }

    public int getGlucose() { return glucose; }
    public void setGlucose(int glucose) { this.glucose = glucose; }

    public int getCarbohydrates() { return carbohydrates; }
    public void setCarbohydrates(int carbohydrates) { this.carbohydrates = carbohydrates; }

    public Medication getPrimaryMedication() { return primaryMedication; }
    public void setPrimaryMedication(Medication primaryMedication) { this.primaryMedication = primaryMedication; }

    public Medication getSecondaryMedication() { return secondaryMedication; }
    public void setSecondaryMedication(Medication secondaryMedication) { this.secondaryMedication = secondaryMedication; }

    public Sleep getSleep() { return sleep; }
    public void setSleep(Sleep sleep) { this.sleep = sleep; }

    public Activity getPhysicalActivity() { return physicalActivity; }
    public void setPhysicalActivity(Activity physicalActivity) { this.physicalActivity = physicalActivity; }

    @Override
    public String toString() {
        return "Glucose Level: " + glucose + '\n' +
                "Carbohydrates: " + carbohydrates + '\n' +
                primaryMedication.getName() + ": " + primaryMedication.getQuantity() + '\n' +
                secondaryMedication.getName() + ": " + secondaryMedication.getQuantity() + '\n' +
                "Has Slept: " + sleep.getHasSlept() + " " + sleep.getStartTime() + " - " + sleep.getEndTime() + '\n' +
                physicalActivity.getType() + ": " + physicalActivity.getStartTime() + " - " + physicalActivity.getEndTime();
    }

    public String leftColumn(){
        String returnedString = "Glucose Level: " + glucose + '\n';
        if(primaryMedication.getName().equals("None")){
            returnedString += "No medication" + '\n';
        }
        else{
            returnedString += primaryMedication.getName() + ": " + primaryMedication.getQuantity() + "U\n";
        }

        if(!sleep.getHasSlept()){
            returnedString += "No sleep" + '\n';
        }
        else{
            returnedString += "Has Slept: \n";
        }

        returnedString += physicalActivity.getType();

        return returnedString;
    }
    public String rightColumn(){
        String returnedString = "Carbohydrates: " + carbohydrates + '\n';
        if(secondaryMedication.getName().equals("None")){
            returnedString += "No medication" + '\n';
        }
        else{
            returnedString += secondaryMedication.getName() + ": " + secondaryMedication.getQuantity() + "U\n";
        }

        if(!sleep.getHasSlept()){
            returnedString += "N/A" + '\n';
        }
        else{
            returnedString += sleep.getStartTime() + " - " + sleep.getEndTime() + '\n';
        }

        if(physicalActivity.getType() == Activity.ActivityTypes.NONE){
            returnedString += "N/A";
        }
        else{
            returnedString += physicalActivity.getStartTime() + " - " + physicalActivity.getEndTime();
        }

        return returnedString;
    }

    public Map<String, Object> getDBFormat(){
        Map<String, Object> dbEntry = new HashMap<>();

        dbEntry.put("date", date.toString());
        dbEntry.put("time", time.toString());
        dbEntry.put("carbohydrates", carbohydrates);
        dbEntry.put("glucose", glucose);
        dbEntry.put("hasSlept", sleep.getHasSlept().toString());
        dbEntry.put("sleepStart", sleep.getStartTime().toString());
        dbEntry.put("sleepEnd", sleep.getEndTime().toString());
        dbEntry.put("physicalActivityType", physicalActivity.getType().toString());
        dbEntry.put("physicalActivityStart", physicalActivity.getStartTime().toString());
        dbEntry.put("physicalActivityEnd", physicalActivity.getEndTime().toString());
        dbEntry.put("primaryMedicationName", primaryMedication.getName());
        dbEntry.put("primaryMedicationQuantity", primaryMedication.getQuantity());
        dbEntry.put("secondaryMedicationName", secondaryMedication.getName());
        dbEntry.put("secondaryMedicationQuantity", secondaryMedication.getQuantity());
        dbEntry.put("userID", MainActivity.loggedUser.getId());

        return dbEntry;
    }
}
