package com.chatapp.threadripper.models;

public class Diary {
    private String status;
    private int imgDiary;

    public Diary(String status, int imgDiary) {
        this.status = status;
        this.imgDiary = imgDiary;
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
}
