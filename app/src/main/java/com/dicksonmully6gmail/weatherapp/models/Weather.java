package com.dicksonmully6gmail.weatherapp.models;

/**
 * Created by dickson on 5/30/17.
 */


public class Weather {
    private String mMain;
    private String mDescription;
    private String mIcon;

//    constructor
    public Weather(String main, String description, String icon) {
        this.mMain = main;
        this.mDescription = description;
        this.mIcon = icon;
    }
//    getter methods
    public String getMain() {
        return mMain;
    }
    public String getDescription() {
        return mDescription;
    }
    public String getIcon() {
        return mIcon;
    }
}