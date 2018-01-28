package com.neildg.mobidev_handsonrepo.activity_restaurant;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

/** Holds reference to the restaurant_item_layout XML
 * Created by NeilDG on 1/27/2018.
 */

public class RestaurantViewHolder extends RecyclerView.ViewHolder {

    private final static String TAG = "RestaurantViewHolder";

    private TextView restaurantNameText;
    private TextView restaurantDescText;
    private TextView weightText;
    private int modelIndex = -1;

    public RestaurantViewHolder(final View itemView) {
        super(itemView);

        this.restaurantNameText = itemView.findViewById(R.id.restaurant_name_text);
        this.restaurantDescText = itemView.findViewById(R.id.restaurant_desc_text);
        this.weightText = itemView.findViewById(R.id.weight_text);

        Button editBtn = itemView.findViewById(R.id.edit_btn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity) itemView.getContext();
                Intent editIntent = new Intent(activity, AddRestaurantActivity.class);
                editIntent.putExtra(AddRestaurantActivity.REQUEST_CODE_KEY, AddRestaurantActivity.EDIT_ACTIVITY_CODE);
                editIntent.putExtra(AddRestaurantActivity.RESTAURANT_NAME_KEY, restaurantNameText.getText().toString());
                editIntent.putExtra(AddRestaurantActivity.RESTAURANT_DESC_KEY, restaurantDescText.getText().toString());
                editIntent.putExtra(AddRestaurantActivity.WEIGHT_KEY, Integer.parseInt(weightText.getText().toString()));
                editIntent.putExtra(AddRestaurantActivity.EDIT_MODEL_INDEX_KEY, modelIndex);
                activity.startActivityForResult(editIntent, AddRestaurantActivity.EDIT_ACTIVITY_CODE);
            }
        });
    }

    public TextView getRestaurantNameText() {
        return this.restaurantNameText;
    }

    public TextView getRestaurantDescText() {
        return this.restaurantDescText;
    }

    public TextView getWeightText() {
        return this.weightText;
    }

    public void setModelIndex(int modelIndex) {
        this.modelIndex = modelIndex;
    }


}
