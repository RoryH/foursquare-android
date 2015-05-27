package com.rhaddon.foursquare.foursquareexample;

/**
 * Created by rhaddon on 26/05/15.
 */
public class Venue {
    String name;
    private FoursquarePhoto bestPhoto;

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
