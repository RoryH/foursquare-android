package com.rhaddon.foursquare.foursquareexample.client;

import java.util.List;

/**
 * Created by rhaddon on 27/05/15.
 */
public class VenueListResponse {
    List<Groups> groups;

    public VenueListResponse() {}

    public List<Groups> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "VenueListResponse{" +
                "groups=" + groups +
                '}';
    }
}
