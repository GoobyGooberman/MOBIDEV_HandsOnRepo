package com.neildg.mobidev_handsonrepo.activity_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

public class LifecycleActivityWorkspace extends AppCompatActivity {

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
        setContentView(R.layout.activity_lifecycle_workspace);

        this.setupUI();
        this.onCreateNum++;
        this.onCreateNumView.setText(""+onCreateNum+"");

        TextView text_view = new TextView(this);
        text_view.setText("Triggered onCreate!");
        this.logLayoutView.addView(text_view);
    }

    @Override
    protected void onStart(){
        super.onStart();
        this.onStartNum++;
        this.onStartNumView.setText(""+onStartNum+"");

        TextView text_view = new TextView(this);
        text_view.setText("Triggered onStart!");
        this.logLayoutView.addView(text_view);
    }

    @Override
    protected void onResume(){
        super.onResume();
        this.onResumeNum++;
        this.onResumeNumView.setText(""+onResumeNum+"");

        TextView text_view = new TextView(this);
        text_view.setText("Triggered onResume!");
        this.logLayoutView.addView(text_view);
    }

    @Override
    protected void onPause(){
        super.onPause();
        this.onPauseNum++;
        this.onPauseNumView.setText(""+onPauseNum+"");

        TextView text_view = new TextView(this);
        text_view.setText("Triggered onPause!");
        this.logLayoutView.addView(text_view);
    }

    @Override
    protected void onStop(){
        super.onStop();
        this.onStopNum++;
        this.onStopNumView.setText(""+onStopNum+"");

        TextView text_view = new TextView(this);
        text_view.setText("Triggered onStop!");
        this.logLayoutView.addView(text_view);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        this.onDestroyNum++;
        this.onDestroyNumView.setText(""+onDestroyNum+"");
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
}
