package com.example.aida.models;

import com.example.aida.utility.Constants;
import com.example.aida.utility.MTime;

public class Sleep {
    private Boolean hasSlept;
    private MTime startTime;
    private MTime endTime;

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

    public Sleep(MTime sleepStart, MTime sleepEnd) {
        this.startTime = sleepStart;
        this.endTime = sleepEnd;
    }

    public Sleep(Boolean hasSlept, MTime sleepStart, MTime sleepEnd) {
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

    public MTime getStartTime() { return startTime; }
    public void setStartTime(MTime sleepStart) { this.startTime = sleepStart; }

    public MTime getEndTime() { return endTime; }
    public void setEndTime(MTime sleepEnd) { this.endTime = sleepEnd; }

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
