package com.example.aida.models.dateTimeModels;

public class VDate {
    private int day;
    private int month;
    private int year;

    public VDate(){
        day = 1;
        month = 1;
        year = 1;
    }

    public VDate(String date){
        if(date.length() == 10) {
            day = Integer.valueOf(String.valueOf(date.charAt(0)) + String.valueOf(date.charAt(1)));
            month = Integer.valueOf(String.valueOf(date.charAt(3)) + String.valueOf(date.charAt(4)));
            year = Integer.valueOf(String.valueOf(date.charAt(6)) + String.valueOf(date.charAt(7)) + String.valueOf(date.charAt(8)) + String.valueOf(date.charAt(9)));

            if(year < 1) {
                year = 1;
            } else if(year > 9999) {
                year = 9999;
            }

            if(month < 1) {
                month = 1;
            } else if(month > 12) {
                month = 12;
            }

            if(day < 1) {
                day = 1;
            } else if(day > 28 && month == 2 && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))) {
                day = 28;
            } else if(day > 29 && month == 2 && (year % 4 == 0 || (year % 100 == 0 && year % 400 == 0))) {
                day = 29;
            } else if(day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
                day = 30;
            } else if(day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
                day = 31;
            }

        } else if(date.length() == 8) {
            day = Integer.valueOf(String.valueOf(date.charAt(0)) + String.valueOf(date.charAt(1)));
            month = Integer.valueOf(String.valueOf(date.charAt(3)) + String.valueOf(date.charAt(4)));
            year = Integer.valueOf(String.valueOf(date.charAt(6)) + String.valueOf(date.charAt(7)));
        } else {
            day = 1;
            month = 1;
            year = 1;
        }
    }

    public VDate(int day, int month, int year) {
        if(year < 1) {
            this.year = 1;
        } else if(year > 9999) {
            this.year = 9999;
        } else {
            this.year = year;
        }

        if(month < 1) {
            this.month = 1;
        } else if(month > 12) {
            this.month = 12;
        } else {
            this.month = month;
        }

        if(day < 1) {
            this.day = 1;
        } else if(day > 28 && month == 2 && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))) {
            this.day = 28;
        } else if(day > 29 && month == 2 && (year % 4 == 0 || (year % 100 == 0 && year % 400 == 0))) {
            this.day = 29;
        } else if(day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            this.day = 30;
        } else if(day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
            this.day = 31;
        } else {
            this.day = day;
        }
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
