package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_restaurant.AddRestaurantActivity;
import com.neildg.mobidev_handsonrepo.activity_restaurant.RestaurantModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class S14_RestaurantActivity extends AppCompatActivity {
    private final static String TAG = "S14_RestaurantActivity";

    private RecyclerView recyclerView;
    private S14_RestaurantAdapter restaurantAdapter;
    private ArrayList<S14_RestaurantModel> restoList = new ArrayList<S14_RestaurantModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s14_restaurant_workspace);

        this.createDefaultRestaurants();
        this.setupRecyclerView();
        this.setupButtons();
    }

    private void createDefaultRestaurants() {
            restoList.add(new S14_RestaurantModel("McDonalds", "Love Ko 'To", 20));
            restoList.add(new S14_RestaurantModel("Jollibee", "Bida ang Saya", 10));
            restoList.add(new S14_RestaurantModel("Zarks", "Greaasy Burgers", 5));
            restoList.add(new S14_RestaurantModel("Chowking", "Chinese Food", 15));
            restoList.add(new S14_RestaurantModel("Sbarro", "Pasta", 12));
            restoList.add(new S14_RestaurantModel("Shakey's", "Pizza", 8));
            restoList.add(new S14_RestaurantModel("Starbucks", "Coffee Place", 10));
            restoList.add(new S14_RestaurantModel("Burger Machine", "Burgers", 6));
            restoList.add(new S14_RestaurantModel("Subway", "Hotdogs", 50));
            restoList.add(new S14_RestaurantModel("Coreon Gate", "Korean Internet and Food", 3));

        //simply log the restaurants in logcat
        for(int i = 0; i < 10; i++){
            Log.d(TAG, "createDefaultRestaurants() returned: " +
                    "Name:  " + restoList.get(i).getRestoName() +
            " Description: " + restoList.get(i).getDescription() +
            " Weight: " + restoList.get(i).getWeight());
        }
    }

    private void setupRecyclerView() {
        this.recyclerView = this.findViewById(R.id.s14_recyclerview);
        this.restaurantAdapter = new S14_RestaurantAdapter(this.restoList);
        RecyclerView.LayoutManager recylerLayoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(recylerLayoutManager);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(this.restaurantAdapter);
    }

    private void setupButtons() {
        Button surpriseBtn = this.findViewById(R.id.s14_surprise_btn);
        surpriseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                S14_RestaurantActivity.this.showSnackbarMessage(
                        randomizeRestaurant().getRestoName());
            }
        });

        Button addBtn = this.findViewById(R.id.s14_add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(S14_RestaurantActivity.this, S14_AddRestaurantActivity.class);
                startActivityForResult(i, S14_AddRestaurantActivity.ADD_REQUEST_CODE);
            }
        });
    }

    private S14_RestaurantModel randomizeRestaurant() {
        ArrayList<S14_RestaurantModel> weightedList = new ArrayList<>();

        for(int i = 0; i < this.restoList.size(); i++) {
            S14_RestaurantModel restaurant = this.restoList.get(i);
            for(int counter = 0; counter < restaurant.getWeight(); counter++) {
                weightedList.add(restaurant);
            }
        }

        Random random = new Random();
        int randomNum = random.nextInt(weightedList.size());

        return weightedList.get(randomNum);
    }

    private void showSnackbarMessage(String restaurantName) {
        Snackbar snackbar = Snackbar.make(S14_RestaurantActivity.this.findViewById(R.id.s14_parent_layout), "LET'S EAT AT " +
                restaurantName+ "!",3000);

        TextView snackbarActionTextView =  snackbar.getView().findViewById( android.support.design.R.id.snackbar_text );
        snackbarActionTextView.setTextSize( 30 );
        snackbarActionTextView.setTypeface(snackbarActionTextView.getTypeface(), Typeface.BOLD);

        snackbar.show();
    }

    private void addRestaurant(String name, String description, int weight) {
        S14_RestaurantModel restaurantModel = new S14_RestaurantModel(name, description, weight);
        this.restoList.add(restaurantModel);

        this.restaurantAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == S14_AddRestaurantActivity.ADD_REQUEST_CODE && data != null) {
            //do something on data
            String name = data.getStringExtra(S14_AddRestaurantActivity.NAME_KEY);
            String desc = data.getStringExtra(S14_AddRestaurantActivity.DESC_KEY);
            int weight = data.getIntExtra(S14_AddRestaurantActivity.WEIGHT_KEY, 0);
            this.addRestaurant(name, desc, weight);
            Log.d(TAG, "ON ACTIVITY RESULT! Request code is:" +requestCode);
        }
    }
}
