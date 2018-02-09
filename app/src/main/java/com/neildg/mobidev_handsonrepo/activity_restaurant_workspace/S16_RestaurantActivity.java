package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_restaurant.RestaurantAdapter;

public class S16_RestaurantActivity extends AppCompatActivity {
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

        //simply log the restaurants in logcat
    }
}
