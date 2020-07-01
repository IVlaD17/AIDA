package com.example.aida.models.journalModels;

import com.example.aida.models.dateTimeModels.VTime;

public class Activity {
    private ActivityTypes type;
    private VTime start;
    private VTime end;

    // Default Constructor
    public Activity(){
        type = ActivityTypes.NONE;
        start = new VTime();
        end = new VTime();
    }

    // Generic Constructor
    public Activity(ActivityTypes type, VTime start, VTime end) {
        this.type = type;
        if(type == ActivityTypes.NONE){
            this.start = new VTime();
            this.end = new VTime();
        } else {
            this.start = start;
            this.end = end;
        }
    }

    // ActivityType String Parameter Constructor
    public Activity(String type, VTime start, VTime end) {
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

        this.start = start;
        this.end = end;
    }

    public ActivityTypes getType() { return type; }
    public void setType(ActivityTypes type) { this.type = type; }

    public VTime getStart() { return start; }
    public void setStart(VTime start) { this.start = start; }

    public VTime getEnd() { return end; }
    public void setEnd(VTime end) { this.end = end; }

    @Override
    public String toString() { return type.toString() + " " + start + " - " + end; }
}
