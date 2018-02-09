package com.neildg.mobidev_handsonrepo.activity_restaurant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neildg.mobidev_handsonrepo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the adapter class that will bind the S16_RestaurantModel model to its corresponding view.
 * Created by NeilDG on 1/27/2018.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder>{
    private final static String TAG = "S16_RestaurantAdapter";

    private List<RestaurantModel> modelList;

    public RestaurantAdapter(ArrayList<RestaurantModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInstance = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item_layout, parent, false);
        return new RestaurantViewHolder(viewInstance);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        RestaurantModel model = this.modelList.get(position);
        holder.setModelIndex(position);
        holder.getRestaurantNameText().setText(model.getName());
        holder.getRestaurantDescText().setText(model.getDescription());
        holder.getWeightText().setText(model.getWeightString());
    }

    @Override
    public int getItemCount() {
        return this.modelList.size();
    }
}
