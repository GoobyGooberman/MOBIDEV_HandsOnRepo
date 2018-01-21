package com.neildg.mobidev_handsonrepo.activity_lifecycle;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LifecycleActivity extends AppCompatActivity {
    private final static String TAG = "LifecycleActivity";

    //keys for STATE SAVING
    private final static String STATE_PREFS_FILE = "StatePrefsFile";
    private final static String CREATE_NUM_KEY = "CREATE_NUM_KEY";
    private final static String START_NUM_KEY = "START_NUM_KEY";
    private final static String RESUME_NUM_KEY = "RESUME_NUM_KEY";
    private final static String ON_PAUSE_NUM_KEY = "ON_PAUSE_NUM_KEY";
    private final static String ON_STOP_NUM_KEY = "ON_STOP_NUM_KEY";
    private final static String ON_DESTROY_NUM_KEY = "ON_DESTROY_NUM_KEY";

    private TextView onCreateNumView;
    private TextView onStartNumView;
    private TextView onResumeNumView;
    private TextView onPauseNumView;
    private TextView onStopNumView;
    private TextView onDestroyNumView;

    private TextView onCreateStampView;
    private TextView onStartStampView;
    private TextView onResumeStampView;
    private TextView onPauseStampView;
    private TextView onStopStampView;
    private TextView onDestroyStampView;

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
        this.restoreState();
        //this.restoreFromBundle(savedInstanceState);
        this.updateValues();

        this.onCreateStampView.setText(this.getTimeStamp());
    }

    private String getTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        String format = simpleDateFormat.format(new Date());

        return format;
    }

    private void setupUI() {
        this.onCreateNumView = (TextView) this.findViewById(R.id.view_oncreate_num);
        this.onStartNumView = (TextView) this.findViewById(R.id.view_onstart_num);
        this.onResumeNumView = (TextView) this.findViewById(R.id.view_onresume_num);
        this.onPauseNumView = (TextView) this.findViewById(R.id.view_pause_num);
        this.onStopNumView = (TextView) this.findViewById(R.id.view_onstop_num);
        this.onDestroyNumView = (TextView) this.findViewById(R.id.view_ondestroy_num);

        this.onCreateStampView = (TextView) this.findViewById(R.id.view_oncreate_stamp);
        this.onStartStampView = (TextView) this.findViewById(R.id.view_onstart_stamp);
        this.onResumeStampView = (TextView) this.findViewById(R.id.view_onresume_stamp);
        this.onPauseStampView = (TextView) this.findViewById(R.id.view_onpause_stamp);
        this.onStopStampView = (TextView) this.findViewById(R.id.view_onstop_stamp);
        this.onDestroyStampView = (TextView) this.findViewById(R.id.view_ondestroy_stamp);

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
        this.onStartStampView.setText(this.getTimeStamp());
        this.updateValues();

        this.logMessage("Triggered onStart!");
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.onResumeNum++;
        this.onResumeStampView.setText(this.getTimeStamp());
        this.updateValues();

        this.logMessage("Triggered onResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();

        this.onPauseNum++;
        this.onPauseStampView.setText(this.getTimeStamp());
        this.updateValues();

        this.logMessage("Triggered onPause!");
    }

    @Override
    protected void onStop() {
        super.onStop();

        this.onStopNum++;
        this.onStopStampView.setText(this.getTimeStamp());
        this.updateValues();

        this.logMessage("Triggered onStop!");
        this.saveState();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        this.onDestroyNum++;
        this.onDestroyStampView.setText(this.getTimeStamp());
        this.updateValues();

        this.logMessage("Triggered onDestroy!");
        this.saveState();
    }

    /*private void restoreFromBundle(Bundle savedInstanceState) {

        if(savedInstanceState == null) {
            return;
        }

        this.onCreateNum += savedInstanceState.getInt(CREATE_NUM_KEY, 0);
        this.onStartNum += savedInstanceState.getInt(START_NUM_KEY, 0);
        this.onResumeNum += savedInstanceState.getInt(RESUME_NUM_KEY, 0);
        this.onPauseNum += savedInstanceState.getInt(ON_PAUSE_NUM_KEY, 0);
        this.onStopNum += savedInstanceState.getInt(ON_STOP_NUM_KEY, 0);
        this.onDestroyNum += savedInstanceState.getInt(ON_DESTROY_NUM_KEY, 0);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CREATE_NUM_KEY, this.onCreateNum);
        outState.putInt(START_NUM_KEY, this.onStartNum);
        outState.putInt(RESUME_NUM_KEY, this.onResumeNum);
        outState.putInt(ON_PAUSE_NUM_KEY, this.onPauseNum);
        outState.putInt(ON_STOP_NUM_KEY, this.onStopNum);
        outState.putInt(ON_DESTROY_NUM_KEY, this.onDestroyNum);

        super.onSaveInstanceState(outState);
    }*/


    private void restoreState() {
        SharedPreferences preferences = this.getSharedPreferences(STATE_PREFS_FILE, MODE_PRIVATE);
        this.onCreateNum += preferences.getInt(CREATE_NUM_KEY, 0);
        this.onStartNum += preferences.getInt(START_NUM_KEY, 0);
        this.onResumeNum += preferences.getInt(RESUME_NUM_KEY, 0);
        this.onPauseNum += preferences.getInt(ON_PAUSE_NUM_KEY, 0);
        this.onStopNum += preferences.getInt(ON_STOP_NUM_KEY, 0);
        this.onDestroyNum += preferences.getInt(ON_DESTROY_NUM_KEY, 0);

        Log.d(TAG, "Updated values!! onCreate: " +this.onCreateNum);
    }

    private void saveState() {
        SharedPreferences preferences = this.getSharedPreferences(STATE_PREFS_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(CREATE_NUM_KEY, this.onCreateNum);
        editor.putInt(START_NUM_KEY, this.onStartNum);
        editor.putInt(RESUME_NUM_KEY, this.onResumeNum);
        editor.putInt(ON_PAUSE_NUM_KEY, this.onPauseNum);
        editor.putInt(ON_STOP_NUM_KEY, this.onStopNum);
        editor.putInt(ON_DESTROY_NUM_KEY, this.onDestroyNum);

       editor.commit(); //IMPORTANT! SAVE CHANGES
        Log.d(TAG, "Successfully saved state");
    }
}
