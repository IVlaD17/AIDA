package com.example.aida.models;

import com.example.aida.utility.Constants;
import com.example.aida.utility.MTime;

public class Activity {
    public enum ActivityTypes{
        NONE { public String toString() {return "No activity";} },
        FOOTBALL { public String toString() {return "Football";} },
        BASKETBALL { public String toString() {return "Basketball";} },
        TENNIS { public String toString() {return "Tennis";} }
    }

    private ActivityTypes type;
    private MTime startTime;
    private MTime endTime;

    public Activity(){
        type = ActivityTypes.NONE;
        startTime = Constants.ZERO_TIME;
        endTime = Constants.ZERO_TIME;
    }

    public Activity(ActivityTypes type) {
        this.type = type;
        if(type == ActivityTypes.NONE){
            this.startTime = Constants.ZERO_TIME;
            this.endTime = Constants.ZERO_TIME;
        }
    }

    // Constructor designed to be used when pulling data from the database
    public Activity(String type, MTime startTime, MTime endTime) {
        if(type.equals("None"))
            this.type = ActivityTypes.NONE;
        else if(type.equals("Football"))
            this.type = ActivityTypes.FOOTBALL;
        else if(type.equals("Basketball"))
            this.type = ActivityTypes.BASKETBALL;
        else if(type.equals("Tennis"))
            this.type = ActivityTypes.TENNIS;
        else
            this.type = ActivityTypes.NONE;

        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Generic Constructor
    public Activity(ActivityTypes type, MTime startTime, MTime endTime) {
        if(type == ActivityTypes.NONE){
            startTime = Constants.ZERO_TIME;
            endTime = Constants.ZERO_TIME;
        }

        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ActivityTypes getType() { return type; }
    public void setType(ActivityTypes type) { this.type = type; }

    public MTime getStartTime() { return startTime; }
    public void setStartTime(MTime startTime) { this.startTime = startTime; }

    public MTime getEndTime() { return endTime; }
    public void setEndTime(MTime endTime) { this.endTime = endTime; }

    @Override
    public String toString() { return type.toString() + startTime + " - " + endTime; }
}
