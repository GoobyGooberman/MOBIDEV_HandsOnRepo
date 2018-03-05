package com.neildg.mobidev_handsonrepo.exam_locker;

import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Handles the logic, adapter, and view design of the locker
 * Created by NeilDG on 2/11/2018.
 */

public class LockerViewHandler {
    private final static String TAG = "LockerViewHandler";

    private Activity holdingActivity;
    private ArrayList<LockerDataModel> lockerDataList = new ArrayList<>();
    private RecyclerView lockerView;
    private LockerAdapter lockerAdapter;

    public LockerViewHandler(RecyclerView lockerView, Activity holdingActivity) {
        this.lockerView = lockerView;
        this.holdingActivity = holdingActivity;

        this.generateKeys();
        this.setupView();

    }

    private void generateKeys() {

        LockerDataModel model = new LockerDataModel(0);
        this.lockerDataList.add(model);

        model = new LockerDataModel(0);
        this.lockerDataList.add(model);

        model = new LockerDataModel(1);
        this.lockerDataList.add(model);

        model = new LockerDataModel(2);
        this.lockerDataList.add(model);

        model = new LockerDataModel(3);
        this.lockerDataList.add(model);

        model = new LockerDataModel(4);
        this.lockerDataList.add(model);

        model = new LockerDataModel(5);
        this.lockerDataList.add(model);

        model = new LockerDataModel(6);
        this.lockerDataList.add(model);

        model = new LockerDataModel(7);
        this.lockerDataList.add(model);

        model = new LockerDataModel(8);
        this.lockerDataList.add(model);

        model = new LockerDataModel(9);
        this.lockerDataList.add(model);

        model = new LockerDataModel(9);
        this.lockerDataList.add(model);

    }

    private void setupView() {
        this.lockerAdapter = new LockerAdapter(this.lockerDataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.holdingActivity);
        this.lockerView.setLayoutManager(layoutManager);
        this.lockerView.setItemAnimator(new DefaultItemAnimator());
        this.lockerView.setAdapter(this.lockerAdapter);
    }

    public LockerDataModel getVisibleItem() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) this.lockerView.getLayoutManager();

        int index =  layoutManager.findFirstVisibleItemPosition() + 1;
        return this.lockerDataList.get(index);
    }

    public void shuffle() {
        Random random = new Random();
        this.lockerView.smoothScrollToPosition(random.nextInt(this.lockerDataList.size()));
    }


}
