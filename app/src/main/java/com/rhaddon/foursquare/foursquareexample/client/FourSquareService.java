package com.rhaddon.foursquare.foursquareexample.client;

import com.rhaddon.foursquare.foursquareexample.model.Venue;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface FourSquareService {
    @GET("/venues/{id}")
    void getVenue(
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("v") String version,
            @Path("id") String venueId,
            Callback<FoursquareResponseWrapper<Venue>> callback);
}
