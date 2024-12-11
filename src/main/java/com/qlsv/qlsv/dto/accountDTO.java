package com.qlsv.qlsv.dto;

public class accountDTO {
    private int id;
    private String username;
    private String passwords;
    private int studentid;
    public int getStudentid() {
        return studentid;
    }
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    public int getId() {
        return id;
    }public String getPasswords() {
        return passwords;
    }
    public String getUsername() {
        return username;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    

}
