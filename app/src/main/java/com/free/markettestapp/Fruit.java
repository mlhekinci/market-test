package com.free.markettestapp;

public class Fruit {


    private String name;
    private int imageId;
    private String introduction;

    public Fruit(String name, int imageId,String introduction) {
        this.name = name;
        this.introduction = introduction;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
