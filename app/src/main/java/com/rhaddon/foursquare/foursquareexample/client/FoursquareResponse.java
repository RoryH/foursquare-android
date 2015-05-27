package com.rhaddon.foursquare.foursquareexample.client;


import com.rhaddon.foursquare.foursquareexample.model.Venue;

public class FoursquareResponse {
    public Venue venue;

    FoursquareResponse() {
    }

    @Override
    public String toString() {
        return "FoursquareResponse( venue=" + venue + " )";
    }
}
