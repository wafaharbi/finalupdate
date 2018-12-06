package com.example.wafa.studentapp;

public class TimeTableModel {

    public  String timeTitle , timeDate ;

    public TimeTableModel(String timeTitle, String timeDate) {
        this.timeTitle = timeTitle;
        this.timeDate = timeDate;
    }

    public TimeTableModel() {
    }

    public String getTimeTitle() {
        return timeTitle;
    }

    public void setTimeTitle(String timeTitle) {
        this.timeTitle = timeTitle;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }
}
