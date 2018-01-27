package com.neildg.mobidev_handsonrepo.activity_restaurant;

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
    private RecyclerView recyclerView;
    private RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        this.createDefaultRestaurants();
        this.setupRecyclerView();
        this.setupButtons();
    }

    private void createDefaultRestaurants() {
        Random randomizer = new Random();

        this.restaurantList.add(new RestaurantModel("Shakey's", "Monster Meal Deal the best!", randomizer.nextInt(10) + 1));
        this.restaurantList.add(new RestaurantModel("Mcdo", "Mcdo at South Gate.", randomizer.nextInt(10) + 1));
        this.restaurantList.add(new RestaurantModel("Healthy Corner", "Located at Agno.", randomizer.nextInt(10) + 1));
        this.restaurantList.add(new RestaurantModel("Good Munch", "Rosemary Chicken... with Egg???", randomizer.nextInt(10) + 1));
        this.restaurantList.add(new RestaurantModel("Jus n Jerry's", "Not my favorite! :(", randomizer.nextInt(10) + 1));
        this.restaurantList.add(new RestaurantModel("Potato Corner", "Giga or Tera? Tough decision.", randomizer.nextInt(10) + 1));
        this.restaurantList.add(new RestaurantModel("Tori Box", "Cholesterol on a box! Yum!", randomizer.nextInt(10) + 1));
    }

    private void setupRecyclerView() {
        this.recyclerView = this.findViewById(R.id.restaurant_recycler_view);
        this.restaurantAdapter = new RestaurantAdapter(this.restaurantList);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(recylerLayoutManager);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(this.restaurantAdapter);
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
        Button surpriseBtn = this.findViewById(R.id.surprise_btn);
        surpriseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(RestaurantActivity.this.findViewById(R.id.restaurant_parent_layout), "LET'S EAT AT " +
                        RestaurantActivity.this.randomizeRestaurant().getName()+ "!",3000);

                TextView snackbarActionTextView =  snackbar.getView().findViewById( android.support.design.R.id.snackbar_text );
                snackbarActionTextView.setTextSize( 30 );
                snackbarActionTextView.setTypeface(snackbarActionTextView.getTypeface(), Typeface.BOLD);

                snackbar.show();

            }
        });
    }
}
