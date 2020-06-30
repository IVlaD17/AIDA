package com.example.aida.models.journalModels;

import com.example.aida.utility.Constants;
import com.example.aida.utility.MTime;

public class Activity {
    private ActivityTypes type;
    private MTime startTime;
    private MTime endTime;

    // Default Constructor
    public Activity(){
        type = ActivityTypes.NONE;
        startTime = Constants.ZERO_TIME;
        endTime = Constants.ZERO_TIME;
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

    // ActivityType String Parameter Constructor
    public Activity(String type, MTime startTime, MTime endTime) {
        switch (type){
            case "Football":
                this.type = ActivityTypes.FOOTBALL;
            case "Basketball":
                this.type = ActivityTypes.BASKETBALL;
            case "Tennis":
                this.type = ActivityTypes.TENNIS;
            case "Handball":
                this.type = ActivityTypes.HANDBALL;
            case "Workout":
                this.type = ActivityTypes.WORKOUT;
            case "Running":
                this.type = ActivityTypes.RUNNING;
            case "Rugby":
                this.type = ActivityTypes.RUGBY;
            case "American Football":
                this.type = ActivityTypes.AMERICAN_FOOTBALL;
            case "Martial Arts":
                this.type = ActivityTypes.MARTIAL_ARTS;
            default:
                this.type = ActivityTypes.NONE;
        }

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
