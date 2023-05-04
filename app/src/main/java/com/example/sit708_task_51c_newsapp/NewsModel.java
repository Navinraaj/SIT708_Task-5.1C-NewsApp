package com.example.sit708_task_51c_newsapp;

public class NewsModel {
    String title, desc;
    int image;
    Boolean status;

    /**
     * NewsModel is a simple model class that holds the data for a single news item.
     */

    public NewsModel(String title, String desc, int image, Boolean status) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }
}
