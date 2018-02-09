package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_restaurant.RestaurantAdapter;

public class S16_RestaurantActivity extends AppCompatActivity {
    private final static String TAG = "S14_RestaurantActivity";

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s14_restaurant_workspace);

        this.createDefaultRestaurants();
    }

    //TODO: Create atleast 10 restaurants that uses a S16_RestaurantModel model
    private void createDefaultRestaurants() {

        //simply log the restaurants in logcat
        S16_RestaurantModel mcdo = new S16_RestaurantModel("Mcdonalds", 1, "Fast Food");
        S16_RestaurantModel jolli = new S16_RestaurantModel("Jollibee", 2, "Fast Food");
        S16_RestaurantModel kfc = new S16_RestaurantModel("KFC", 3, "Fast Food");
        S16_RestaurantModel tokyo = new S16_RestaurantModel("Tokyo Tokyo", 4, "Fast Food");
        S16_RestaurantModel inasal = new S16_RestaurantModel("Mang Inasal", 5, "Fast Food");
        S16_RestaurantModel raps = new S16_RestaurantModel("Raps", 6, "Fast Food");
        S16_RestaurantModel resto_2 = new S16_RestaurantModel("Dunkin Donuts", 7, "Fast Food");
        S16_RestaurantModel resto_3 = new S16_RestaurantModel("Sbarro", 8, "Fast Food");
        S16_RestaurantModel resto_4 = new S16_RestaurantModel("Jus and Jerry", 9, "Fast Food");
        S16_RestaurantModel resto_5 = new S16_RestaurantModel("Wai Ying", 10, "Fast Food");


        Log.v("Name", mcdo.getName());
        Log.v("Weight", Integer.toString(mcdo.getWeight()));
        Log.v("Description", mcdo.getDescription());

        Log.v("Name", jolli.getName());
        Log.v("Weight", Integer.toString(jolli.getWeight()));
        Log.v("Description", jolli.getDescription());

        Log.v("Name", kfc.getName());
        Log.v("Weight", Integer.toString(kfc.getWeight()));
        Log.v("Description", kfc.getDescription());

        Log.v("Name", tokyo.getName());
        Log.v("Weight", Integer.toString(tokyo.getWeight()));
        Log.v("Description", tokyo.getDescription());

        Log.v("Name", inasal.getName());
        Log.v("Weight", Integer.toString(inasal.getWeight()));
        Log.v("Description", inasal.getDescription());

        Log.v("Name", raps.getName());
        Log.v("Weight", Integer.toString(raps.getWeight()));
        Log.v("Description", raps.getDescription());

        Log.v("Name", resto_2.getName());
        Log.v("Weight", Integer.toString(resto_2.getWeight()));
        Log.v("Description", resto_2.getDescription());

        Log.v("Name", resto_3.getName());
        Log.v("Weight", Integer.toString(resto_3.getWeight()));
        Log.v("Description", resto_3.getDescription());

        Log.v("Name", resto_4.getName());
        Log.v("Weight", Integer.toString(resto_4.getWeight()));
        Log.v("Description", resto_4.getDescription());

        Log.v("Name", resto_5.getName());
        Log.v("Weight", Integer.toString(resto_5.getWeight()));
        Log.v("Description", resto_5.getDescription());


    }
}
