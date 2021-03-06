package com.example.doordashdiscover.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.doordashdiscover.models.RestaurantDetails;
import com.example.doordashdiscover.repositories.RestaurantRepository;

public class RestaurantViewModel extends ViewModel {
    private final RestaurantRepository mRestaurantRepository;
    private String mRestaurantId;
    private boolean mDidRetrieveRestaurant;

    public RestaurantViewModel() {
        this.mRestaurantRepository = RestaurantRepository.getInstance();
        mDidRetrieveRestaurant = false;
    }

    public LiveData<RestaurantDetails> getRestaurant() {
        return mRestaurantRepository.getRestaurant();
    }

    public LiveData<Boolean> isRestaurantRequestTimeout() {
        return mRestaurantRepository.isRestaurantRequestTimedOut();
    }

    public void getRestaurantApi(String id) {
        mRestaurantId = id;
        mRestaurantRepository.getRestaurantApi(id);
    }

    public String getRestaurantId() {
        return mRestaurantId;
    }

    public boolean didRetrieveRestaurant() {
        return mDidRetrieveRestaurant;
    }

    public void setRetrieveRestaurant(boolean mDidRetrieveRestaurant) {
        this.mDidRetrieveRestaurant = mDidRetrieveRestaurant;
    }
}
