package com.example.radiusassignment.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RiderInfo{
    private String message;
    private boolean success;
    private Data data;


    public RiderInfo(String message, boolean success, Data data) {
        this.message = message;
        this.success = success;
        this.data = data;

    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public Data getData() {
        return data;
    }


}
