package com.example.aida.models.dateTimeModels;

public class VDate {
    private int day;
    private int month;
    private int year;

    public VDate(){
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public VDate(String date){
        this.day = Integer.valueOf(String.valueOf(date.charAt(0)) + String.valueOf(date.charAt(1)));
        this.month = Integer.valueOf(String.valueOf(date.charAt(3)) + String.valueOf(date.charAt(4)));
        if(date.length() == 8)
            this.year = Integer.valueOf(String.valueOf(date.charAt(6)) + String.valueOf(date.charAt(7)));
        else
            this.year = Integer.valueOf(String.valueOf(date.charAt(6)) + String.valueOf(date.charAt(7)) +
                    String.valueOf(date.charAt(8)) + String.valueOf(date.charAt(9)));
    }

    public VDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

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
