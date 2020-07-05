package com.example.aida.models.dateTimeModels;

public class VTime {
    private int second;
    private int minute;
    private int hour;

    public VTime() {
        second = 0;
        minute = 0;
        hour = 0;
    }

    public VTime(String time){
        if(time.length() == 8) {
            second = Integer.valueOf(String.valueOf(time.charAt(6)) + String.valueOf(time.charAt(7)));
            minute = Integer.valueOf(String.valueOf(time.charAt(3)) + String.valueOf(time.charAt(4)));
            hour = Integer.valueOf(String.valueOf(time.charAt(0)) + String.valueOf(time.charAt(1)));

            if(second < 0){
                this.second = 0;
            } else if(second > 59) {
                this.second = 59;
            }

            if(minute < 0) {
                this.minute = 0;
            } else if(minute > 59) {
                this.minute = 59;
            }

            if(hour < 0) {
                this.hour = 0;
            } else if(hour > 23) {
                this.hour = 23;
            }

        } else if(time.length() == 5) {
            second = 0;
            minute = Integer.valueOf(String.valueOf(time.charAt(3)) + String.valueOf(time.charAt(4)));
            hour = Integer.valueOf(String.valueOf(time.charAt(0)) + String.valueOf(time.charAt(1)));

            if(minute < 0) {
                this.minute = 0;
            } else if(minute > 59) {
                this.minute = 59;
            }

            if(hour < 0) {
                this.hour = 0;
            } else if(hour > 23) {
                this.hour = 23;
            }

        } else {
            second = 0;
            minute = 0;
            hour = 0;
        }
    }

    public VTime(int second, int minute, int hour) {
        if(second < 0){
            this.second = 0;
        } else if(second > 59) {
            this.second = 59;
        } else {
            this.second = second;
        }

        if(minute < 0) {
            this.minute = 0;
        } else if(minute > 59) {
            this.minute = 59;
        } else {
            this.minute = minute;
        }

        if(hour < 0) {
            this.hour = 0;
        } else if(hour > 23) {
            this.hour = 23;
        } else {
            this.hour = hour;
        }
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
