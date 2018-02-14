package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

/**
 * Created by Administrator on 2/14/2018.
 */

public class S14_RestaurantViewHolder extends RecyclerView.ViewHolder {
    private TextView restaurantName;
    private TextView restaurantDescription;
    private TextView restaurantWeight;

    public S14_RestaurantViewHolder(View view){
        super(view);
        restaurantName = view.findViewById(R.id.s14restoname);
        restaurantDescription = view.findViewById(R.id.s14restodesc);
        restaurantWeight = view.findViewById(R.id.s14restoweight);
    }

    public TextView getRestaurantName() {
        return restaurantName;
    }

    public TextView getRestaurantDescription() {
        return restaurantDescription;
    }

    public TextView getRestaurantWeight() {
        return restaurantWeight;
    }
}
