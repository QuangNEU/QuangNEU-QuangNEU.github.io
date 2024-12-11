package com.qlsv.qlsv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="grade")
public class grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "attendance_grade")
    private float attendance_grade;

    @Column(name = "midterm_grade")
    private float midterm_grade;

    @Column(name = "final_exam_grade")
    private float final_exam_grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private course course1;
    public float getDTB(){
        return 0.1f*attendance_grade+0.4f*midterm_grade+0.5f*final_exam_grade;
    }
    public float getAttendance_grade() {
        return attendance_grade;
    }
    public course getCourse() {
        return course1;
    }
public course getCourse1() {
    return course1;
}
    public float getFinal_exam_grade() {
        return final_exam_grade;
    }

    public int getId() {
        return id;
    }
    public float getMidterm_grade() {
        return midterm_grade;
    }
    public student getStudent() {
        return student;
    }
    public void setAttendance_grade(float attendance_grade) {
        this.attendance_grade = attendance_grade;
    }
    public void setCourse(course course) {
        this.course1 = course;
    }
    public void setFinal_exam_grade(float final_exam_grade) {
        this.final_exam_grade = final_exam_grade;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setMidterm_grade(float midterm_grade) {
        this.midterm_grade = midterm_grade;
    }
    public void setStudent_id(student student_id) {
        this.student = student_id;
    }
    
}   
