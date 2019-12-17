package com.example.radiusassignment.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.radiusassignment.Model.RiderInfo;
import com.example.radiusassignment.Model.Trip;
import com.example.radiusassignment.NetworkService;
import com.example.radiusassignment.R;
import com.example.radiusassignment.Adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private RecyclerAdapter recyclerAdapter;
private RecyclerView recyclerView;
private TextView userName;
private TextView location;
private TextView rides;
private TextView freeRides;
private TextView credits;
private CircleImageView profilePic;
private List<Trip> tripsList;
private static final String api_endpoint = "https://gist.githubusercontent.com/iranjith4/522d5b466560e91b8ebab54743f2d0fc/raw/7b108e4aaac287c6c3fdf93c3343dd1c62d24faf/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        tripsList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(api_endpoint)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        NetworkService networkService = retrofit.create(NetworkService.class);
        Call<RiderInfo> call = networkService.fetchRiderInfo();
        call.enqueue(new Callback<RiderInfo>() {
            @Override
            public void onResponse(Call<RiderInfo> call, Response<RiderInfo> response) {
                if(response.isSuccessful())
                {
                    RiderInfo riderInfo = response.body();
                    String first_name = riderInfo.getData().getProfile().getFirst_name();
                    String last_name = riderInfo.getData().getProfile().getLast_name();
                    String full_name = first_name + " " + last_name;
                    userName.setText(full_name);
                    String city = riderInfo.getData().getProfile().getCity();
                    String country = riderInfo.getData().getProfile().getCountry();
                    String locationString = city + "," + " " + country;
                    location.setText(locationString);
                    rides.setText(riderInfo.getData().getStats().getRides());
                    freeRides.setText(riderInfo.getData().getStats().getFree_rides());
                    credits.setText(riderInfo.getData().getStats().getCredits().getCurrency_symbol() + riderInfo.getData().getStats().getCredits().getValue());
                    Glide
                            .with(MainActivity.this)
                            .load(riderInfo.getData().getProfile().getMiddle_name())
                            .into(profilePic);
                    tripsList = riderInfo.getData().getTrips();
                    recyclerAdapter = new RecyclerAdapter(MainActivity.this,tripsList);
                    recyclerView.setAdapter(recyclerAdapter);
                }
            }

            @Override
            public void onFailure(Call<RiderInfo> call, Throwable t) {

            }
        });

    }
    private void findViews()
    {
        recyclerView = findViewById(R.id.recycler_view);
        userName = findViewById(R.id.user_name);
        location = findViewById(R.id.location_text);
        rides = findViewById(R.id.rides_text);
        freeRides = findViewById(R.id.free_rides);
        credits = findViewById(R.id.credits_text);
        profilePic = findViewById(R.id.profile_pic);
    }
}
