package com.example.carouselsliderimage;

import android.graphics.Color;
import android.widget.TextView;

public class TeamModelClass {

    private  Integer image;
    private String Teamtext;
    private String color;

    public TeamModelClass(Integer image, String teamtext, String color) {
        this.image = image;
        Teamtext = teamtext;
        this.color = color;
    }

    public Integer getImage() {
        return image;
    }

    public String getTeamtext() {
        return Teamtext;
    }

    public String getColor() {
        return color;
    }
}
