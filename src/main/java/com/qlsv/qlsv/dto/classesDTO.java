package com.qlsv.qlsv.dto;

import com.qlsv.qlsv.entity.course;
import com.qlsv.qlsv.entity.instructor;



public class classesDTO {
    private int id;
    private String day_of_the_week;
    private String start_time;
    private String end_time;
    private String room;
    private course course;
    private instructor instructor;

    public course getCourse() {
        return course;
    }
    public String getDay_of_the_week() {
        return day_of_the_week;
    }public String getEnd_time() {
        return end_time;
    }public int getId() {
        return id;
    }public instructor getInstructor() {
        return instructor;
    }
   
    public String getRoom() {
        return room;
    }
    public String getStart_time() {
        return start_time;
    }
    public void setCourse(course course) {
        this.course = course;
    }public void setDay_of_the_week(String day_of_the_week) {
        this.day_of_the_week = day_of_the_week;
    }public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }public void setId(int id) {
        this.id = id;
    }public void setInstructor(instructor instructor) {
        this.instructor = instructor;
    }public void setRoom(String room) {
        this.room = room;
    }public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
}

