package com.example.doordashdiscover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.doordashdiscover.models.Menu;
import com.example.doordashdiscover.models.Restaurant;
import com.example.doordashdiscover.requests.DiscoverApi;
import com.example.doordashdiscover.requests.ServiceGenerator;
import com.example.doordashdiscover.responses.RestaurantDetailResponse;
import com.example.doordashdiscover.responses.RestaurantResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscoverActivity extends BaseActivity {

    private static String TAG = "DiscoverActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //testRetrofitRequest();
        testRestaurantDetailRequest();
    }

    private void testRestaurantDetailRequest() {
        DiscoverApi discoverApi = ServiceGenerator.getDiscoverApi();
        Call<RestaurantDetailResponse> restaurantDetailResponseCall = discoverApi.
                getRestaurantDetail("1");

        restaurantDetailResponseCall.enqueue(new Callback<RestaurantDetailResponse>() {
            @Override
            public void onResponse(Call<RestaurantDetailResponse> call, Response<RestaurantDetailResponse> response) {
                Log.d(TAG, "onResponse: server responses: " + response.body().toString());
                if(response.code() == 200) {
                    Log.d(TAG, "onResponse: "+ response.body().toString());
                    List<Menu> menus = new ArrayList<>(response.body().getMenus());
                    for(Menu m : menus) {
                        Log.d(TAG, "onResponse: "+ m.getName());
                    }
                } else {
                    Log.d(TAG, "onResponse: "+ response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<RestaurantDetailResponse> call, Throwable t) {

            }
        });
    }

    private void testRetrofitRequest() {
        DiscoverApi discoverApi = ServiceGenerator.getDiscoverApi();
        Call<RestaurantResponse> restaurantResponseCall = discoverApi.
                getRestaurants(
                        "37.422740",
                        "-122.139956",
                        "0",
                        "50"
                );

        restaurantResponseCall.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                Log.d(TAG, "onResponse: server responses: " + response.body().toString());
                if(response.code() == 200) {
                    Log.d(TAG, "onResponse: "+ response.body().toString());
                    List<Restaurant> restaurants = new ArrayList<>(response.body().getRestaurants());
                    for(Restaurant r : restaurants) {
                        Log.d(TAG, "onResponse: "+ r.getName());
                    }
                } else {
                    Log.d(TAG, "onResponse: "+ response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {

            }
        });
    }
}