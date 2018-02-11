package com.mobidev.mobidev_exam.exam_locker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobidev.mobidev_exam.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeilDG on 2/11/2018.
 */

public class LockerAdapter extends RecyclerView.Adapter<LockerViewHolder> {
    private final static String TAG = "S16_RestaurantAdapter";

    private List<LockerDataModel> modelList;

    public LockerAdapter(ArrayList<LockerDataModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public LockerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //TODO: modify this
       return null;
    }

    @Override
    public void onBindViewHolder(LockerViewHolder holder, int position) {
        //TODO: modify this
    }

    @Override
    public int getItemCount() {
        return this.modelList.size();
    }
}
