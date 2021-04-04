package com.example.doordashdiscover.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.doordashdiscover.R;
import com.example.doordashdiscover.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int RESTAURANT_TYPE = 1;
    private static final int LOADING_TYPE = 2;
    private static final String LOADING_ID = "FakeLoadingId";

    private List<Restaurant> mRestaurants;
    private OnRestaurantClickListener mOnRestaurantClickListener;
    private Context mContext;

    public RestaurantRecyclerAdapter(OnRestaurantClickListener mOnRestaurantClickListener, Context context) {
        this.mOnRestaurantClickListener = mOnRestaurantClickListener;
        this.mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case LOADING_TYPE: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_loading_list_item, parent, false);
                return new LoadingViewHolder(view);
            }

            case RESTAURANT_TYPE:
            default: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.restaurant_item, parent, false);
                return new RestaurantViewHolder(view, mOnRestaurantClickListener);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType == RESTAURANT_TYPE) {
            RestaurantViewHolder vh = (RestaurantViewHolder) holder;
            vh.name.setText(mRestaurants.get(position).getName());
            vh.description.setText(mRestaurants.get(position).getDescription());
            vh.status.setText(TextUtils.isEmpty(mRestaurants.get(position).getDisplayStatus())
                    ? "" : getContext().getResources().getString(R.string.status_string, mRestaurants.get(position).getDisplayStatus()));
            vh.deliveryFee.setText(String.valueOf(mRestaurants.get(position).getDisplay_delivery_fee()));

            RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
            Glide.with(vh.itemView.getContext())
                    .setDefaultRequestOptions(requestOptions)
                    .load(mRestaurants.get(position).getCover_img_url())
                    .into(vh.image);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(mRestaurants.get(position).getId().equals(LOADING_ID)) {
            return LOADING_TYPE;
        } else if (position != 0 && position == mRestaurants.size() - 1) {
            return LOADING_TYPE;
        } else {
            return RESTAURANT_TYPE;
        }
    }

    public void displayLoading() {
        if(!isLoading()) {
            Restaurant item = new Restaurant();
            item.setId(LOADING_ID);
            List<Restaurant> list = new ArrayList<>();
            list.add(item);
            mRestaurants = list;
            notifyDataSetChanged();
        }
    }

    private boolean isLoading() {
        if (mRestaurants != null && mRestaurants.size() > 0) {
            return mRestaurants.get(mRestaurants.size() - 1).getId().equals(LOADING_ID);
        }
        return false;
    }

    @Override
    public int getItemCount() {
        if(mRestaurants != null) {
            return mRestaurants.size();
        }
        return 0;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        mRestaurants = restaurants;
        notifyDataSetChanged();
    }

    public Restaurant getSelectedRestaurant(int position) {
        if(mRestaurants != null && mRestaurants.size() > 0) {
            return mRestaurants.get(position);
        }
        return null;
    }
}