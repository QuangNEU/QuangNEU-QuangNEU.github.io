package com.qlsv.qlsv.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "course")

public class course {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name ="credits")
    private int credits;
    @OneToMany(mappedBy =  "course1")
    private Set<grade> ListGrade;

    @OneToMany(mappedBy = "course")
    private Set<classes> ListClasses;
    public Set<grade> getListGrade() {
        return ListGrade;
    }
    public void setListGrade(Set<grade> listGrade) {
        ListGrade = listGrade;
    }
    public Set<classes> getListClasses() {
        return ListClasses;
    }
    public int getCourse_id() {
        return id;
    }
    public int getCredits() {
        return credits;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public void setCourse_id(int course_id) {
        this.id = course_id;
    }public void setCredits(int credits) {
        this.credits = credits;
    }
    public void setListClasses(Set<classes> listClasses) {
        ListClasses = listClasses;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
