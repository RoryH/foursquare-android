package com.rhaddon.foursquare.foursquareexample.client;

import com.rhaddon.foursquare.foursquareexample.model.Venue;

public class VenueDetailResponse {

    public Venue venue;

    VenueDetailResponse() {
    }

    public Venue getVenue() {
        return venue;
    }

    @Override
    public String toString() {
        return "VenueDetailResponse{" +
                "venue=" + venue +
                '}';
    }
}