package com.rhaddon.foursquare.foursquareexample;


public class FoursquareResponse {
    public Venue venue;

    FoursquareResponse() {
    }

    @Override
    public String toString() {
        return "FoursquareResponse( venue=" + venue + " )";
    }
}
