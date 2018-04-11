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
    private int notifNumber = 0;

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
    }

    public void logMessage(final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView messageView = new TextView(ThreadActivity.this);
                messageView.setText(message);
                ThreadActivity.this.consoleContainer.addView(messageView);
            }
        });

    }

    public void notify(final String message) {
        DownloadNotification.notify(ThreadActivity.this, message, notifNumber);
        notifNumber++;
        /*this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DownloadNotification.notify(ThreadActivity.this, message, notifNumber);
                notifNumber++;
            }
        });*/
    }

    private void startThreading() {
        for(int i = 0; i < this.threadList.length; i++) {
            this.threadList[i] = new SampleThread(i, this);
            this.threadList[i].start();
        }

        this.logMessage("Finished threading demo.");
    }
}
