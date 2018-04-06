package com.neildg.mobidev_handsonrepo.activity_thread;

import android.util.Log;

/**
 * Created by Administrator on 4/6/2018.
 */

public class SampleThread extends Thread {
    private final static String TAG = "SampleThread";

    private int threadID;

    public SampleThread(int ID) {
        this.threadID = ID;
    }

    @Override
    public void run() {
       //your thread implements your logic here
        Log.d(TAG, "Thread " +threadID+ " has started");

        //pause for 1 second
        try {
            Thread.sleep(1000); //example of a slow bandwidth
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "Thread " +threadID+ " has finished");
    }
}
