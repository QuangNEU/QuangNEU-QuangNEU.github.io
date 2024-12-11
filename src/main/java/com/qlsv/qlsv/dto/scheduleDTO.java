package com.qlsv.qlsv.dto;

public class scheduleDTO {

    private int student_id;

    private String Thu;
    private String subj_name;
    private String S_time;
    private String E_time;
    private String room;
    private int classId;
    public int getClassId() {
        return classId;
    }
    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public String getSubj_name() {
        return subj_name;
    }

    public String getThu() {
        return Thu;
    }

    public String getE_time() {
        return E_time;
    }

    public String getS_time() {
        return S_time;
    }

    public void setE_time(String e_time) {
        E_time = e_time;
    }

    public void setS_time(String s_time) {
        S_time = s_time;
    }

    public void setSubj_name(String subj_name) {
        this.subj_name = subj_name;
    }

    public void setThu(String thu) {
        Thu = thu;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

}
