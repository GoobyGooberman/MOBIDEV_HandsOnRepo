package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_restaurant.RestaurantAdapter;

import java.util.ArrayList;

public class S14_RestaurantActivity extends AppCompatActivity {
    private final static String TAG = "S14_RestaurantActivity";

    private RecyclerView recyclerView;
    private RestaurantAdapter restaurantAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s14_restaurant_workspace);

        this.createDefaultRestaurants();
    }

    //TODO: Create atleast 10 restaurants that uses a restaurant model
    private void createDefaultRestaurants() {
        ArrayList<S14_RestaurantModel> resto = new ArrayList<S14_RestaurantModel>();
            resto.add(new S14_RestaurantModel("McDonalds", "Love Ko 'To", 20));
            resto.add(new S14_RestaurantModel("Jollibee", "Bida ang Saya", 10));
            resto.add(new S14_RestaurantModel("Zarks", "Greaasy Burgers", 5));
            resto.add(new S14_RestaurantModel("Chowking", "Chinese Food", 15));
            resto.add(new S14_RestaurantModel("Sbarro", "Pasta", 12));
            resto.add(new S14_RestaurantModel("Shakey's", "Pizza", 8));
            resto.add(new S14_RestaurantModel("Starbucks", "Coffee Place", 10));
            resto.add(new S14_RestaurantModel("Burger Machine", "Burgers", 6));
            resto.add(new S14_RestaurantModel("Subway", "Hotdogs", 14));
            resto.add(new S14_RestaurantModel("Coreon Gate", "Korean Internet and Food", 3));

        //simply log the restaurants in logcat

        for(int i = 0; i < 10; i++){
            Log.d(TAG, "createDefaultRestaurants() returned: " +
                    "Name:  " +resto.get(i).getRestoName() +
            " Description: " + resto.get(i).getDescription() +
            " Weight: " + resto.get(i).getWeight());
        }
    }
}
