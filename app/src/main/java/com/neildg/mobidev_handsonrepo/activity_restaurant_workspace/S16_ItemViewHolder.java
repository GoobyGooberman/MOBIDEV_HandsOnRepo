package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

/**
 * Created by Administrator on 2/9/2018.
 */

public class S16_ItemViewHolder extends RecyclerView.ViewHolder{
    private TextView restaurantname;
    private TextView description;
    private TextView weight;

    public S16_ItemViewHolder(View itemView) {
        super(itemView);
        restaurantname = itemView.findViewById(R.id.restaurantname);
        description = itemView.findViewById(R.id.description);
        weight = itemView.findViewById(R.id.weight);
    }

    public TextView getRestaurantname() {
        return restaurantname;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getWeight() {
        return weight;
    }
}
