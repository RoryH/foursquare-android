package com.rhaddon.foursquare.foursquareexample.client;

/**
 * Created by rhaddon on 26/05/15.
 */
public class FoursquarePhoto {

    private String prefix;
    private String suffix;
    private int width;
    private int height;

    FoursquarePhoto() {

    }

    public String getUrl() {
        return prefix + "width" + width + suffix;
    }

}