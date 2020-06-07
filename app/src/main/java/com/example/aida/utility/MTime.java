package com.example.aida.utility;

public class MTime {
    private int second;
    private int minute;
    private int hour;

    public MTime(String time){
        this.hour = Integer.valueOf(String.valueOf(time.charAt(0)) + String.valueOf(time.charAt(1)));
        this.minute = Integer.valueOf(String.valueOf(time.charAt(3)) + String.valueOf(time.charAt(4)));
        this.second = 0;
    }

    public MTime(int minute, int hour) {
        this.minute = minute;
        this.hour = hour;
        this.second = 0;
    }

    public MTime(int second, int minute, int hour) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public int getSecond() { return second; }
    //public void setSecond(int second) { this.second = second; }

    public int getMinute() { return minute; }
    //public void setMinute(int minute) { this.minute = minute; }

    public int getHour() { return hour; }
    //public void setHour(int hour) { this.hour = hour; }

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

        //if(second < 10)
        //    timeString += ":0" + second;
        //else
        //    timeString += ":" + second;

        return timeString;
    }
}
