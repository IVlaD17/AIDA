package com.example.aida.models.journalModels;

import com.example.aida.utility.Constants;
import com.example.aida.models.dateTimeModels.VTime;

public class Sleep {
    private Boolean hasSlept;
    private VTime start;
    private VTime end;

    // Default Constructor
    public Sleep(){
        hasSlept = false;
        start = Constants.ZERO_TIME;
        end = Constants.ZERO_TIME;
    }

    // Generic Constructor
    public Sleep(Boolean hasSlept, VTime start, VTime end) {
        this.hasSlept = hasSlept;

        if(!hasSlept){
            this.start = Constants.ZERO_TIME;
            this.end = Constants.ZERO_TIME;
        } else {
            this.start = start;
            this.end = end;
        }
    }

    public Boolean getHasSlept() { return hasSlept; }
    public void setHasSlept(Boolean hasSlept) { this.hasSlept = hasSlept; }

    public VTime getStart() { return start; }
    public void setStart(VTime start) { this.start = start; }

    public VTime getEnd() { return end; }
    public void setEnd(VTime end) { this.end = end; }

    @Override
    public String toString() {
        if(hasSlept) {
            return "Has Slept: " + start + " - " + end;
        }
        else {
            return  "No Sleep";
        }
    }
}
