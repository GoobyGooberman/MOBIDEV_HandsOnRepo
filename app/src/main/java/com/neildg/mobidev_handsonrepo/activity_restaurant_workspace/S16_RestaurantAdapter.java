package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neildg.mobidev_handsonrepo.R;

import java.util.List;

/**
 * Created by Administrator on 2/9/2018.
 */

public class S16_RestaurantAdapter extends RecyclerView.Adapter<S16_ItemViewHolder> {
    private List<S16_RestaurantModel> restaurants;
    private S16_ItemViewHolder restaurantviewholder;

    public S16_RestaurantAdapter(List<S16_RestaurantModel> restaurants){
        this.restaurants = restaurants;
    }

    @Override
    public S16_ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.s16_layout_item, parent, false);
        return new S16_ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder (S16_ItemViewHolder holder, int position){
        S16_RestaurantModel restaurant = this.restaurants.get(position);
        holder.getRestaurantname().setText(restaurant.getName());
        holder.getDescription().setText(restaurant.getDescription());
        holder.getWeight().setText(Integer.toString(restaurant.getWeight()));
    }

    @Override
    public int getItemCount(){
        return this.restaurants.size();
    }
}
