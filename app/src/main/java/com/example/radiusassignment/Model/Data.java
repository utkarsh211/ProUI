package com.example.radiusassignment.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    private Profile profile;
    private Stats stats;
    @SerializedName("trips")
    @Expose
    private List<Trip> trips;
    public Profile getProfile() {
        return profile;
    }

    public Stats getStats() {
        return stats;
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
