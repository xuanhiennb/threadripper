package com.chatapp.threadripper.models;

public class Diary {
    private String status;
    private int imgDiary;
    private String time;



    public Diary(String status, int imgDiary, String time) {
        this.status = status;
        this.imgDiary = imgDiary;
        this.time = time;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImgDiary() {
        return imgDiary;
    }

    public void setImgDiary(int imgDiary) {
        this.imgDiary = imgDiary;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
//
//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }
}
