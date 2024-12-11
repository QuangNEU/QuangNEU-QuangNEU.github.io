package com.qlsv.qlsv.payload;



public class responseData {
    private int status;
    private String desc;
    private Object data;
    
    public Object getData() {
        return data;
    }
    public String getDesc() {
        return desc;
    }
    public int getStatus() {
        return status;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
}
