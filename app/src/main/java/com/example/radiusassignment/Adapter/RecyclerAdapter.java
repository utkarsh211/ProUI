package com.example.radiusassignment.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.radiusassignment.Model.Trip;
import com.example.radiusassignment.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
private Context context;
private List<Trip> tripsList;

    public RecyclerAdapter(Context context, List<Trip> tripsList) {
        this.context = context;
        this.tripsList = tripsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.recycler_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Trip trip = tripsList.get(position);
        holder.startPoint.setText(trip.getFrom());
        holder.endPoint.setText(trip.getTo());
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        long milliSeconds= trip.getFrom_time();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        holder.startTime.setText(formatter.format(calendar.getTime()));
        long milliSeconds1= trip.getTo_time();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(milliSeconds1);
        holder.endTime.setText(formatter.format(calendar1.getTime()));
        holder.fare.setText(trip.getCost().getValue());
        int hours = Integer.valueOf(trip.getTrip_duration_in_mins()) / 60;
        int minutes = Integer.valueOf(trip.getTrip_duration_in_mins()) % 60;
        if(hours>0) {
            holder.travelTime.setText(hours + "h" + " " + minutes + "min");
        }
        else
        {
            holder.travelTime.setText(minutes + "min");
        }
    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView startPoint;
        TextView endPoint;
        TextView startTime;
        TextView endTime;
        TextView fare;
        TextView travelTime;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            startPoint = itemView.findViewById(R.id.start_point);
            endPoint = itemView.findViewById(R.id.end_point);
            startTime = itemView.findViewById(R.id.start_time);
            endTime = itemView.findViewById(R.id.end_time);
            fare = itemView.findViewById(R.id.fare_text);
            travelTime = itemView.findViewById(R.id.travel);
        }
    }
}
