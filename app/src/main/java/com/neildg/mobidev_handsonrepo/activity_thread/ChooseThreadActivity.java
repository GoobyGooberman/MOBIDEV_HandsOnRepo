package com.neildg.mobidev_handsonrepo.activity_thread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_musicplayer.ChooseMusicActivity;
import com.neildg.mobidev_handsonrepo.activity_musicplayer.MusicPlayerActivity;
import com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace.S14_MusicPlayerActivity;
import com.neildg.mobidev_handsonrepo.activity_musicplayer_workspace.S16_MusicPlayerActivity;

public class ChooseThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_thread);
        this.setupUI();
    }

    private void setupUI() {
        Button mobidevBtn = this.findViewById(R.id.mobidev_s14_btn);
        mobidevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseThreadActivity.this, S14_ThreadActivity.class);
                startActivity(i);
            }
        });

        Button wirtecBtn = this.findViewById(R.id.wirtec_s16_btn);
        wirtecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseThreadActivity.this, ThreadActivity.class);
                startActivity(i);
            }
        });

    }
}
