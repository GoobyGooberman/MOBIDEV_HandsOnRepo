package com.neildg.mobidev_handsonrepo.activity_thread;

import android.util.Log;

/**
 * Created by Administrator on 4/11/2018.
 */

public class S14_SampleThread extends Thread {
    private final static String TAG = "S14_SampleThread";

    private S14_ThreadActivity threadActivity;
    private int threadID;

    public S14_SampleThread(int i, S14_ThreadActivity threadActivity) {
        this.threadID = i;
        this.threadActivity = threadActivity;
    }

    @Override
    public void run() {
        Log.d(TAG, "Thread " +this.threadID+ " has started.");
        this.threadActivity.logMessage("Thread " +this.threadID+ " has started.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "Thread " +this.threadID+ " finished.");
        this.threadActivity.logMessage("Thread " +this.threadID+ " finished.");
    }
}
