package com.neildg.mobidev_handsonrepo.activity_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

import org.w3c.dom.Text;

public class LifecycleActivity extends AppCompatActivity {
    private final static String TAG = "LifecycleActivity";


    private TextView onCreateNumView;
    private TextView onStartNumView;
    private TextView onResumeNumView;
    private TextView onPauseNumView;
    private TextView onStopNumView;
    private TextView onDestroyNumView;

    private LinearLayout logLayoutView;

    private int onCreateNum = 0;
    private int onStartNum = 0;
    private int onResumeNum = 0;
    private int onPauseNum = 0;
    private int onStopNum = 0;
    private int onDestroyNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        this.onCreateNum++;
        this.setupUI();
        this.updateValues();
    }

    private void setupUI() {
        this.onCreateNumView = (TextView) this.findViewById(R.id.view_oncreate_num);
        this.onStartNumView = (TextView) this.findViewById(R.id.view_onstart_num);
        this.onResumeNumView = (TextView) this.findViewById(R.id.view_onresume_num);
        this.onPauseNumView = (TextView) this.findViewById(R.id.view_pause_num);
        this.onStopNumView = (TextView) this.findViewById(R.id.view_onstop_num);
        this.onDestroyNumView = (TextView) this.findViewById(R.id.view_ondestroy_num);

        this.logLayoutView = (LinearLayout) this.findViewById(R.id.log_layout_view);
        this.logLayoutView.removeAllViews();
    }

    /*
     * Simply update all values at once
     */
    private void updateValues() {
        this.onCreateNumView.setText(Integer.toString(this.onCreateNum));
        this.onStartNumView.setText(Integer.toString(this.onStartNum));
        this.onResumeNumView.setText(Integer.toString(this.onResumeNum));
        this.onPauseNumView.setText(Integer.toString(this.onPauseNum));
        this.onStopNumView.setText(Integer.toString(this.onStopNum));
        this.onDestroyNumView.setText(Integer.toString(this.onDestroyNum));
    }

    private void logMessage(String message) {
        TextView messageView = new TextView(this);
        messageView.setText(message);
        this.logLayoutView.addView(messageView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.onStartNum++;
        this.updateValues();

        this.logMessage("Triggered onStart!");
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.onResumeNum++;
        this.updateValues();

        this.logMessage("Triggered onResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();

        this.onPauseNum++;
        this.updateValues();

        this.logMessage("Triggered onPause!");
    }

    @Override
    protected void onStop() {
        super.onStop();

        this.onStopNum++;
        this.updateValues();

        this.logMessage("Triggered onStop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        this.onDestroyNum++;
        this.updateValues();

        this.logMessage("Triggered onDestroy!");
    }
}
