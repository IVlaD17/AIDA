package com.example.aida.models.dateTimeModels;

public class VTime {
    private int second;
    private int minute;
    private int hour;

    public VTime(String time){
        this.hour = Integer.valueOf(String.valueOf(time.charAt(0)) + String.valueOf(time.charAt(1)));
        this.minute = Integer.valueOf(String.valueOf(time.charAt(3)) + String.valueOf(time.charAt(4)));
        this.second = 0;
    }

    public VTime(int second, int minute, int hour) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public int getSecond() { return second; }
    public int getMinute() { return minute; }
    public int getHour() { return hour; }

    @Override
    public String toString() {
        String timeString;

        if(hour < 10)
            timeString = "0" + hour;
        else
            timeString = Integer.toString(hour);

        if(minute < 10)
            timeString += ":0" + minute;
        else
            timeString += ":" + minute;

        return timeString;
    }
}
