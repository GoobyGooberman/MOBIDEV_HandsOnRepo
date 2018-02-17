package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_restaurant_workspace.S14_RestaurantModel;
import com.neildg.mobidev_handsonrepo.activity_restaurant_workspace.S14_RestaurantViewHolder;

import java.util.ArrayList;

/**
 * Created by Administrator on 2/14/2018.
 */

public class S14_RestaurantAdapter extends RecyclerView.Adapter<S14_RestaurantViewHolder>{

    ArrayList<S14_RestaurantModel> restaurants;

    public S14_RestaurantAdapter(ArrayList<S14_RestaurantModel> restaurants){
        this.restaurants = restaurants;
    }

    @Override
    public S14_RestaurantViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.s14_list_item, parent, false);
        return new S14_RestaurantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(S14_RestaurantViewHolder holder, int position){
        S14_RestaurantModel currentResto = restaurants.get(position);

        holder.getRestaurantName().setText(currentResto.getRestoName());
        holder.getRestaurantDescription().setText(currentResto.getDescription());
        holder.getRestaurantWeight().setText(Integer.toString(currentResto.getWeight()));


        holder.getRestaurantName().setTag(currentResto);


    }


    @Override
    public int getItemCount(){
        return restaurants.size();
    }
}





