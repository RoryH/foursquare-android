package com.rhaddon.foursquare.foursquareexample.client;


public class FoursquareResponseWrapper<T> {
    public FoursquareResponse response;

    FoursquareResponseWrapper() {
    }

    @Override
    public String toString() {
        return "FoursquareResponseWrapper( venue=" + response + " )";
    }

}
