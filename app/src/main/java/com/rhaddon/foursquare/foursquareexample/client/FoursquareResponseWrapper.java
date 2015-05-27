package com.rhaddon.foursquare.foursquareexample.client;
public class FoursquareResponseWrapper<T> {

    public T response;

    FoursquareResponseWrapper() {
    }

    public T getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "FoursquareResponseWrapper{" +
                "response=" + response +
                '}';
    }
}