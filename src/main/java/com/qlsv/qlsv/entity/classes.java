package com.qlsv.qlsv.entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "classes")

public class classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "day_of_the_week")
    private String day_of_the_week;

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "end_time")
    private String end_time;

    @Column(name = "room")
    private String room;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private course course;

    @ManyToOne
    @JoinColumn(name = "intructor_id")
    private instructor instructor;

    @OneToMany(mappedBy = "classes1")
    private Set<enrollment> ListEnrollment;
    
    
    public course getCourse() {
        return course;
    }
    public instructor getInstructor() {
        return instructor;
    }
    public void setCourse(course course) {
        this.course = course;
    }
    public void setInstructor(instructor instructor) {
        this.instructor = instructor;
    }
    
    public Set<enrollment> getListEnrollment() {
        return ListEnrollment;
    }
    public String getDay_of_the_week() {
        return day_of_the_week;
    }
    public String getEnd_time() {
        return end_time;
    }
    public int getId() {
        return id;
    }
    
    public String getStart_time() {
        return start_time;
    }   
    public void setDay_of_the_week(String day_of_the_week) {
        this.day_of_the_week = day_of_the_week;
    }
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    public void setListEnrollment(Set<enrollment> listEnrollment) {
        ListEnrollment = listEnrollment;
    }
   
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
}
