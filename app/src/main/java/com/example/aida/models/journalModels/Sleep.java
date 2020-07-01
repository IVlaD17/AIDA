package com.example.aida.models.journalModels;

import com.example.aida.models.dateTimeModels.VTime;

public class Sleep {
    private Boolean hasSlept;
    private VTime start;
    private VTime end;

    // Default Constructor
    public Sleep(){
        hasSlept = false;
        start = new VTime();
        end = new VTime();
    }

    // Generic Constructor
    public Sleep(Boolean hasSlept, VTime start, VTime end) {
        this.hasSlept = hasSlept;

        if(!hasSlept){
            this.start = new VTime();
            this.end = new VTime();
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
