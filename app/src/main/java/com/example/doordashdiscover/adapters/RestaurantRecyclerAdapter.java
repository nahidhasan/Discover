package com.example.doordashdiscover.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doordashdiscover.R;
import com.example.doordashdiscover.models.Restaurant;

import java.util.List;

public class RestaurantRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Restaurant> mRestaurants;
    private OnRestaurantClickListener mOnRestaurantClickListener;

    public RestaurantRecyclerAdapter(List<Restaurant> mRestaurants, OnRestaurantClickListener mOnRestaurantClickListener) {
        this.mRestaurants = mRestaurants;
        this.mOnRestaurantClickListener = mOnRestaurantClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_item, parent, false);
        return new RestaurantViewHolder(view, mOnRestaurantClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RestaurantViewHolder vh = (RestaurantViewHolder) holder;
        vh.name.setText(mRestaurants.get(position).getName());
        vh.description.setText(mRestaurants.get(position).getDescription());
        //todo status, deliveryFee
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        mRestaurants = restaurants;
        notifyDataSetChanged();
    }
}
