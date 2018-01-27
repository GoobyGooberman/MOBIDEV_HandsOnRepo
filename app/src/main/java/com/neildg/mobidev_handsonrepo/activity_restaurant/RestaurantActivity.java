package com.neildg.mobidev_handsonrepo.activity_restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.neildg.mobidev_handsonrepo.R;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    private ArrayList<RestaurantModel> restaurantList = new ArrayList<RestaurantModel>();
    private RecyclerView recyclerView;
    private RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        this.createDefaultRestaurants();
        this.setupRecyclerView();
    }

    private void createDefaultRestaurants() {
        this.restaurantList.add(new RestaurantModel("Shakey's", "Monster Meal Deal the best!"));
        this.restaurantList.add(new RestaurantModel("Mcdo", "Mcdo at South Gate."));
        this.restaurantList.add(new RestaurantModel("Healthy Corner", "Located at Agno."));
        this.restaurantList.add(new RestaurantModel("Good Munch", "Rosemary Chicken... with Egg???"));
        this.restaurantList.add(new RestaurantModel("Jus n Jerry's", "Not my favorite! :("));
        this.restaurantList.add(new RestaurantModel("Potato Corner", "Giga or Tera? Tough decision."));
        this.restaurantList.add(new RestaurantModel("Tori Box", "Cholesterol on a box! Yum!"));
    }

    private void setupRecyclerView() {
        this.recyclerView = this.findViewById(R.id.restaurant_recycler_view);
        this.restaurantAdapter = new RestaurantAdapter(this.restaurantList);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(recylerLayoutManager);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(this.restaurantAdapter);
    }
}
