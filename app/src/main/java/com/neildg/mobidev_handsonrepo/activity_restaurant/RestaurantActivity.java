package com.neildg.mobidev_handsonrepo.activity_restaurant;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

import java.util.ArrayList;
import java.util.Random;

public class RestaurantActivity extends AppCompatActivity {

    private ArrayList<RestaurantModel> restaurantList = new ArrayList<RestaurantModel>();
    //private RecyclerView recyclerView;
    //private RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        this.createDefaultRestaurants();
        this.setupRecyclerView();
        this.setupButtons();
    }

    private void createDefaultRestaurants() {

    }

    private void setupRecyclerView() {

    }
    
    private RestaurantModel randomizeRestaurant() {
        ArrayList<RestaurantModel> weightedList = new ArrayList<>();

        for (int i = 0; i < this.restaurantList.size(); i++) {
            int weight = this.restaurantList.get(i).getWeight();

            for(int j = 0; j < weight; j++) {
                weightedList.add(this.restaurantList.get(i));
            }
        }

        int randomNum = new Random().nextInt(weightedList.size());
        return weightedList.get(randomNum);
    }

    private void setupButtons() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
