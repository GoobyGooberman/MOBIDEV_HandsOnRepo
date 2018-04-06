package com.neildg.mobidev_handsonrepo.activity_thread;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

public class ThreadActivity extends AppCompatActivity {
    private final static String TAG = "ThreadActivity";

    private LinearLayout consoleContainer;
    private TextView msgTemplate;

    private SampleThread[] threadList = new SampleThread[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        this.setupLogMessage();
        this.startThreading();
    }

    private void setupLogMessage() {
        this.msgTemplate = this.findViewById(R.id.thread_message);
        this.consoleContainer = this.findViewById(R.id.console_container);

        for(int i = 0; i < 5; i++) {
            this.logMessage("Message test!");
        }
    }

    private void logMessage(String message) {
        TextView messageView = new TextView(this);
        messageView.setText(message);
        this.consoleContainer.addView(messageView);
    }

    private void startThreading() {
        for(int i = 0; i < this.threadList.length; i++) {
            this.threadList[i] = new SampleThread(i);
            this.threadList[i].start();
        }

        Log.d(TAG, "Finished threading demo.");
    }
}
