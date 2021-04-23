package com.example.doordashdiscover.adapters;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doordashdiscover.R;

public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView name, description, deliveryFee, status;
    AppCompatImageView image;
    AppCompatCheckBox favorite;
    OnRestaurantClickListener onRestaurantClickListener;

    public RestaurantViewHolder(@NonNull View itemView, OnRestaurantClickListener onRestaurantClickListener) {
        super(itemView);
        image = itemView.findViewById(R.id.restaurant_cover_image);
        name = itemView.findViewById(R.id.restaurant_item_name);
        description = itemView.findViewById(R.id.restaurant_item_description);
        deliveryFee = itemView.findViewById(R.id.restaurant_item_delivery_fee);
        status = itemView.findViewById(R.id.restaurant_item_status);
        favorite = itemView.findViewById(R.id.favorite);


        this.onRestaurantClickListener = onRestaurantClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onRestaurantClickListener.onRestaurantClick(getAdapterPosition());
    }
}
