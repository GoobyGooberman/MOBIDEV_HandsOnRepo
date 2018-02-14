package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

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
import com.neildg.mobidev_handsonrepo.activity_restaurant.RestaurantAdapter;
import com.neildg.mobidev_handsonrepo.activity_restaurant.RestaurantModel;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class S16_RestaurantActivity extends AppCompatActivity {
    private final static String TAG = "S14_RestaurantActivity";

    private RecyclerView recyclerView;
    private ArrayList<S16_RestaurantModel> restoList=new ArrayList<>();
    private S16_RestaurantAdapter rAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s16_activity_restaurant);

        this.createDefaultRestaurants();
        this.setupRecyclerView();
        this.setupButtons();
    }

    //TODO: Create atleast 10 restaurants that uses a S16_RestaurantModel model
    private void createDefaultRestaurants() {

        //simply log the restaurants in logcat
        S16_RestaurantModel mcdo = new S16_RestaurantModel("Mcdonalds", 1, "Fast Food");
        restoList.add(mcdo);
        S16_RestaurantModel jolli = new S16_RestaurantModel("Jollibee", 2, "Fast Food");
        restoList.add(jolli);
        S16_RestaurantModel kfc = new S16_RestaurantModel("KFC", 3, "Fast Food");
        restoList.add(kfc);
        S16_RestaurantModel tokyo = new S16_RestaurantModel("Tokyo Tokyo", 4, "Fast Food");
        restoList.add(tokyo);
        S16_RestaurantModel inasal = new S16_RestaurantModel("Mang Inasal", 5, "Fast Food");
        restoList.add(inasal);
        S16_RestaurantModel raps = new S16_RestaurantModel("Raps", 6, "Fast Food");
        restoList.add(raps);
        S16_RestaurantModel dunkin = new S16_RestaurantModel("Dunkin Donuts", 7, "Fast Food");
        restoList.add(dunkin);
        S16_RestaurantModel sbarro = new S16_RestaurantModel("Sbarro", 8, "Fast Food");
        restoList.add(sbarro);
        S16_RestaurantModel jus = new S16_RestaurantModel("Jus and Jerry", 9, "Fast Food");
        restoList.add(jus);
        S16_RestaurantModel wai = new S16_RestaurantModel("Wai Ying", 50, "Fast Food");
        restoList.add(wai);
    }

    private void setupRecyclerView() {
        recyclerView= findViewById(R.id.s16_restaurant_recycler_view);

        rAdapter= new S16_RestaurantAdapter(restoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(rAdapter);
    }

    private void setupButtons() {
        Button surpriseBtn = this.findViewById(R.id.s16_surprise_btn);
        surpriseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                S16_RestaurantModel selectedResto = randomizeRestaurants();
                S16_RestaurantActivity.this.showSnackbarMessage(selectedResto.getName());
            }
        });
    }

    private S16_RestaurantModel randomizeRestaurants() {
        ArrayList<S16_RestaurantModel> weightedList = new ArrayList<>();
        for(int i = 0; i < this.restoList.size(); i++) {
            S16_RestaurantModel model = this.restoList.get(i);
            for(int count = 0; count < model.getWeight(); count++) {
                weightedList.add(model);
            }
        }

        Random random = new Random();
        return weightedList.get(random.nextInt(weightedList.size()));
    }

    private void showSnackbarMessage(String restaurantName) {
        Snackbar snackbar = Snackbar.make(S16_RestaurantActivity.this.findViewById(R.id.s16_restaurant_parent_layout), "LET'S EAT AT " +
                restaurantName+ "!",3000);

        TextView snackbarActionTextView =  snackbar.getView().findViewById( android.support.design.R.id.snackbar_text );
        snackbarActionTextView.setTextSize( 30 );
        snackbarActionTextView.setTypeface(snackbarActionTextView.getTypeface(), Typeface.BOLD);

        snackbar.show();
    }
}
