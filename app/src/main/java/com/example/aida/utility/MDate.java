package com.example.aida.utility;

public class MDate {
    private int day;
    private int month;
    private int year;

    public MDate(String date){
        this.day = Integer.valueOf(String.valueOf(date.charAt(0)) + String.valueOf(date.charAt(1)));
        this.month = Integer.valueOf(String.valueOf(date.charAt(3)) + String.valueOf(date.charAt(4)));
        if(date.length() == 8)
            this.year = Integer.valueOf(String.valueOf(date.charAt(6)) + String.valueOf(date.charAt(7)));
        else
            this.year = Integer.valueOf(String.valueOf(date.charAt(6)) + String.valueOf(date.charAt(7)) +
                    String.valueOf(date.charAt(8)) + String.valueOf(date.charAt(9)));
    }

    public MDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() { return day; }
    //public void setDay(int day) { this.day = day; }

    public int getMonth() { return month; }
    //public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    //public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        String dateString;

        if(day < 10)
            dateString = "0" + day;
        else
            dateString = Integer.toString(day);

        if(month < 10)
            dateString += "/0" + month;
        else
            dateString += "/" + month;

        if(year < 10)
            dateString += "/000" + year;
        else if(year < 100)
            dateString += "/00" + year;
        else if(year < 1000)
            dateString += "/0" + year;
        else
            dateString += "/" + year;

        return dateString;
    }
}
