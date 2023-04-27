package com.example.newtasknews;

public class NewsModel {
    String title, desc;
    int image;
    Boolean status;

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
