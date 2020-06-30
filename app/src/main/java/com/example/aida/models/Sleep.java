package com.example.aida.models;

import com.example.aida.utility.Constants;
import com.example.aida.models.dateTimeModels.VTime;

public class Sleep {
    private Boolean hasSlept;
    private VTime startTime;
    private VTime endTime;

    public Sleep(){
        hasSlept = false;
        startTime = Constants.ZERO_TIME;
        endTime = Constants.ZERO_TIME;
    }

    public Sleep(Boolean hasSlept) {
        this.hasSlept = hasSlept;
        if(!hasSlept){
            this.startTime = Constants.ZERO_TIME;
            this.endTime = Constants.ZERO_TIME;
        }
    }

    public Sleep(VTime sleepStart, VTime sleepEnd) {
        this.startTime = sleepStart;
        this.endTime = sleepEnd;
    }

    public Sleep(Boolean hasSlept, VTime sleepStart, VTime sleepEnd) {
        if(!hasSlept){
            sleepStart = Constants.ZERO_TIME;
            sleepEnd = Constants.ZERO_TIME;
        }

        this.hasSlept = hasSlept;
        this.startTime = sleepStart;
        this.endTime = sleepEnd;
    }

    public Boolean getHasSlept() { return hasSlept; }
    public void setHasSlept(Boolean hasSlept) { this.hasSlept = hasSlept; }

    public VTime getStartTime() { return startTime; }
    public void setStartTime(VTime sleepStart) { this.startTime = sleepStart; }

    public VTime getEndTime() { return endTime; }
    public void setEndTime(VTime sleepEnd) { this.endTime = sleepEnd; }

    @Override
    public String toString() {
        String finalString;

        if(hasSlept) {
            finalString = "Has Slept: " + startTime + " - " + endTime;
        }
        else {
            finalString = "No Sleep";
        }

        return finalString;
    }
}
