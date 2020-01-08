package com.darayuth.weatherapi.model;


/****** Weather Api *******/
public class Weather {
    private String temp;
    private int cloud;


    public Weather(){};

    public Weather(String temp, int cloud) {
        this.temp = temp;
        this.cloud = cloud;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }
}
