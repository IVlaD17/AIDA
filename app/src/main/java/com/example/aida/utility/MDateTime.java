package com.example.aida.utility;

public class MDateTime {
    private MDate date;
    private MTime time;

    public MDateTime(MDate date, MTime time) {
        this.date = date;
        this.time = time;
    }

    public MDate getDate() { return date; }
    public void setDate(MDate date) { this.date = date; }

    public MTime getTime() { return time; }
    public void setTime(MTime time) { this.time = time; }

    @Override
    public String toString() { return time.toString() + " - " + date.toString(); }
}
