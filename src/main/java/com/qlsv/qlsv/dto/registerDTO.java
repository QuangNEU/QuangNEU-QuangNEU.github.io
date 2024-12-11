package com.qlsv.qlsv.dto;


public class registerDTO {
    private int Id;

    private int student_id;

    private int class_id;
    
    public int getClass_id() {
        return class_id;
    }
    public int getId() {
        return Id;
    }public int getStudent_id() {
        return student_id;
    }public void setClass_id(int class_id) {
        this.class_id = class_id;
    }public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }public void setId(int id) {
        Id = id;
    }
    
}
