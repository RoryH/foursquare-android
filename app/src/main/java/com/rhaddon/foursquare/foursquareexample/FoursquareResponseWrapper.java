package com.rhaddon.foursquare.foursquareexample;


public class FoursquareResponseWrapper<T> {
    public FoursquareResponse response;

    FoursquareResponseWrapper() {
    }

    @Override
    public String toString() {
        return "FoursquareResponseWrapper( venue=" + response + " )";
    }

}
