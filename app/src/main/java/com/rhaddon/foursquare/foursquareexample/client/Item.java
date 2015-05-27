package com.rhaddon.foursquare.foursquareexample.client;

import com.rhaddon.foursquare.foursquareexample.model.Venue;

/**
 * Created by rhaddon on 27/05/15.
 */
public class Item {
    public Venue venue;

    public Item() {}

    public Venue getVenue() {
        return venue;
    }

    @Override
    public String toString() {
        return "Item{" +
                "venue=" + venue +
                '}';
    }
}
