package com.mobidev.mobidev_exam.exam_locker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobidev.mobidev_exam.R;

import java.util.ArrayList;

public class LockerActivity extends AppCompatActivity {

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
        //setup your three "locks" here
    }

    private void setupButtons() {
        /*TODO: Add button listeners! If you already have the button functionalities, then remove 'setEnabled' function call and replace
         *TODO: with an onClick listener!
         */
        Button addBtn = this.findViewById(R.id.add_btn);
        addBtn.setEnabled(false);

        Button enterBtn = this.findViewById(R.id.enter_btn);
        enterBtn.setEnabled(false);

        Button shuffleBtn = this.findViewById(R.id.shuffle_btn);
        shuffleBtn.setEnabled(false);
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
