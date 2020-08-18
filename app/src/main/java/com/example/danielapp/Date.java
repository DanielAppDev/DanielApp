package com.example.danielapp;

public class Date {

    private String date;
    private String dateId;

    public Date(String date, String dateId) {
        this.date = date;
        this.dateId = dateId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    @Override
    public String toString() {
        return "Date{" +
                "date='" + date + '\'' +
                ", dateId='" + dateId + '\'' +
                '}';
    }
}
