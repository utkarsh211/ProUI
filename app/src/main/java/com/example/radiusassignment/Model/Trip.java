package com.example.radiusassignment.Model;

public class Trip {
    private String from;
    private String to;
    private long from_time;
    private long to_time;
    private Cost cost;
    private String trip_duration_in_mins;

    public Trip(String from, String to, long from_time, long to_time, Cost cost, String trip_duration_in_mins) {
        this.from = from;
        this.to = to;
        this.from_time = from_time;
        this.to_time = to_time;
        this.cost = cost;
        this.trip_duration_in_mins = trip_duration_in_mins;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public long getFrom_time() {
        return from_time;
    }

    public long getTo_time() {
        return to_time;
    }

    public Cost getCost() {
        return cost;
    }

    public String getTrip_duration_in_mins() {
        return trip_duration_in_mins;
    }


}
