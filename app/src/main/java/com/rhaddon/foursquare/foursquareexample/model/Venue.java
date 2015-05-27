package com.rhaddon.foursquare.foursquareexample.model;

import com.rhaddon.foursquare.foursquareexample.client.FoursquarePhoto;

/**
 * Created by rhaddon on 26/05/15.
 */
public class Venue {
    public String name;
    private FoursquarePhoto bestPhoto;

    public Venue(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Venue(name=" + name + ", photoUrl=" + bestPhoto.getUrl()+ ")";
    }

    public String getBestPhoto() {
        return bestPhoto.getUrl();
    }

    public void setBestPhoto(FoursquarePhoto bestPhoto) {
        this.bestPhoto = bestPhoto;
    }
}
