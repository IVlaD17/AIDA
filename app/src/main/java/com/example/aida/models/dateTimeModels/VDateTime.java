package com.example.aida.models.dateTimeModels;

public class VDateTime {
    private VDate date;
    private VTime time;

    public VDateTime() {
        this.date = new VDate();
        this.time = new VTime();
    }

    public VDateTime(VDate date, VTime time) {
        this.date = date;
        this.time = time;
    }

    public VDate getDate() { return date; }
    public void setDate(VDate date) { this.date = date; }

    public VTime getTime() { return time; }
    public void setTime(VTime time) { this.time = time; }

    @Override
    public String toString() { return time.toString() + " - " + date.toString(); }
}
