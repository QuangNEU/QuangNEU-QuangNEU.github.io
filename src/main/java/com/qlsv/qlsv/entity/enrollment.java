package com.qlsv.qlsv.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "enrollment")

public class enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private student student;

    @ManyToOne
    @JoinColumn(name = "classes_id")
    private classes classes1;

    public enrollment() {}

    public enrollment(student student, classes classes) {
        this.student = student;
        this.classes1 = classes;
    }
    
    public classes getClasses1() {
        return classes1;
    }
    public int getId() {
        return Id;
    }
    public student getStudent() {
        return student;
    }
    public void setClasses1(classes classes1) {
        this.classes1 = classes1;
    }
    public void setId(int id) {
        Id = id;
    }
    public void setStudent(student student) {
        this.student = student;
    }
}
