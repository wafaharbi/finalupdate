package com.example.wafa.studentapp;

import java.io.Serializable;
import java.util.HashMap;

public class Attendance implements Serializable {

    public String week , day , date , course;

    public Attendance() {
    }

    public String getWeek() {
        return week;
    }

    public String setWeek(String week) {
        this.week = week;
        return week;
    }

    public String getDay() {
        return day;
    }

    public String setDay(String day) {
        this.day = day;
        return day;
    }

    public String getDate() {
        return date;
    }

    public String setDate(String date) {
        this.date = date;
        return date;
    }

    public String getCourse() {
        return course;
    }

    public String setCourse(String course) {
        this.course = course;
        return course;
    }

    public HashMap<String,String> toFirebaseObject() {


        HashMap<String,String> attendances =  new HashMap<String,String>();
        attendances.put("week", week);
        attendances.put("day", day);
        attendances.put("date", date);

        return attendances;
    }
}
