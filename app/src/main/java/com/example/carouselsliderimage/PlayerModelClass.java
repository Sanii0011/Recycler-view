package com.example.carouselsliderimage;

public class PlayerModelClass {

    private  Integer image;
    private String text;
    private String color;

    public PlayerModelClass(Integer image, String text, String color) {
        this.image = image;
        this.text = text;
        this.color = color;
    }

    public Integer getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }
}
