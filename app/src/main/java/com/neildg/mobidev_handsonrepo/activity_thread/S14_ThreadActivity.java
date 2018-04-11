package com.neildg.mobidev_handsonrepo.activity_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

public class S14_ThreadActivity extends AppCompatActivity {
    private final static String TAG = "S14_ThreadActivity";

    private LinearLayout consoleContainer;
    private TextView msgTemplate;
    private S14_SampleThread[] threadList = new S14_SampleThread[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s14__thread);

        this.setupLogMessage();
        this.startThreading();
    }

    private void startThreading() {
        for(int i = 0; i < this.threadList.length; i++) {
            this.threadList[i] = new S14_SampleThread(i, this);
            this.threadList[i].start();
        }
    }

    private void setupLogMessage() {
        this.msgTemplate = this.findViewById(R.id.thread_message);
        this.consoleContainer = this.findViewById(R.id.console_container);
    }

    public void logMessage(final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView messageView = new TextView(S14_ThreadActivity.this);
                messageView.setText(message);
                S14_ThreadActivity.this.consoleContainer.addView(messageView);
            }
        });
    }
}
