package com.rhaddon.foursquare.foursquareexample.model;

import android.net.Uri;

import com.rhaddon.foursquare.foursquareexample.client.FoursquarePhoto;

/**
 * Created by rhaddon on 26/05/15.
 */
public class Venue {
    public String name;
    public String id;
    public String url;
    public FoursquarePhoto bestPhoto;

    public Venue(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Venue(name=" + name + ", id=" + id + ")";
    }
}
