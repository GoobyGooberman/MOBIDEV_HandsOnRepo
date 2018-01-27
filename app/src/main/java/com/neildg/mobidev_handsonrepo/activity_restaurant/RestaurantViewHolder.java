package com.neildg.mobidev_handsonrepo.activity_restaurant;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

/** Holds reference to the restaurant_item_layout XML
 * Created by NeilDG on 1/27/2018.
 */

public class RestaurantViewHolder extends RecyclerView.ViewHolder {

    private final static String TAG = "RestaurantViewHolder";

    private TextView restaurantNameText;
    private EditText restaurantDescText;
    private TextView weightText;

    public RestaurantViewHolder(View itemView) {
        super(itemView);

        this.restaurantNameText = itemView.findViewById(R.id.restaurant_name_text);
        this.restaurantDescText = itemView.findViewById(R.id.restaurant_desc_text);
        this.weightText = itemView.findViewById(R.id.weight_text);
    }

    public TextView getRestaurantNameText() {
        return this.restaurantNameText;
    }

    public EditText getRestaurantDescText() {
        return this.restaurantDescText;
    }

    public TextView getWeightText() {
        return this.weightText;
    }


}
