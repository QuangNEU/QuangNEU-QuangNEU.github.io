package com.qlsv.qlsv.payload.request;

public class SubRequest {
    private int studentid;
    private int classid;
    
    public int getClassid() {
        return classid;
    }
    public int getStudentid() {
        return studentid;
    }
    public void setClassid(int classid) {
        this.classid = classid;
    }
    
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
}
