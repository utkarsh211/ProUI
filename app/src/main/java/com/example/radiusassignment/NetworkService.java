package com.example.radiusassignment;

import com.example.radiusassignment.Model.RiderInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("radius-mobile-intern.json")
    Call<RiderInfo> fetchRiderInfo();
}
