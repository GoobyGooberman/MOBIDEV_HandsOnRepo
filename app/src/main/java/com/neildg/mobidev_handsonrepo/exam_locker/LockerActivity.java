package com.neildg.mobidev_handsonrepo.exam_locker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LockerActivity extends AppCompatActivity {

    private LockerViewHandler[] lockerViewHandlers = new LockerViewHandler[3];
    private ArrayList<String> acceptedCombinations = new ArrayList<>();

    private TextView combinationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locker);

        this.setupLocks();
        this.setupButtons();
        this.setDefaultCombinations();
    }

    private void setupLocks() {
        this.combinationView = this.findViewById(R.id.combination_txt_view);
        RecyclerView lockView = this.findViewById(R.id.lock_view_1);
        this.lockerViewHandlers[0] =  new LockerViewHandler(lockView, this);

        lockView = this.findViewById(R.id.lock_view_2);
        this.lockerViewHandlers[1] = new LockerViewHandler(lockView, this);

        lockView = this.findViewById(R.id.lock_view_3);
        this.lockerViewHandlers[2] = new LockerViewHandler(lockView, this);
    }

    private void setupButtons() {
        Button enterBtn = this.findViewById(R.id.enter_btn);

        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = lockerViewHandlers[0].getVisibleItem().getNumberString();
                String b = lockerViewHandlers[1].getVisibleItem().getNumberString();
                String c = lockerViewHandlers[2].getVisibleItem().getNumberString();

                LockerActivity.this.verifyAndUnlock(a,b,c);
            }
        });

        Button shuffleBtn = this.findViewById(R.id.shuffle_btn);
        shuffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lockerViewHandlers[0].shuffle();
                lockerViewHandlers[1].shuffle();
                lockerViewHandlers[2].shuffle();
            }
        });
    }

    private void verifyAndUnlock(String a, String b, String c) {
        String combination = a + b + c;
        boolean unlocked = false;

        for(int i = 0; i < this.acceptedCombinations.size(); i++) {
            if(combination.compareTo(this.acceptedCombinations.get(i)) ==  0) {
                unlocked = true;
                break;
            }
        }

        if(unlocked) {
            combinationView.setText("ACCESS GRANTED!");
            Intent unlockIntent = new Intent(LockerActivity.this, UnlockActivity.class);
            this.startActivity(unlockIntent);
        }
        else {
            combinationView.setText("Combination " +combination+ " is invalid! ACCESS DENIED!");
        }
    }

    private void setDefaultCombinations() {
        this.acceptedCombinations.add("123");
        this.acceptedCombinations.add("567");
        this.acceptedCombinations.add("444");
    }
}
