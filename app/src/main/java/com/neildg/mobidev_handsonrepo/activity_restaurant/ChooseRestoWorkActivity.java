package com.neildg.mobidev_handsonrepo.activity_restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.neildg.mobidev_handsonrepo.R;
import com.neildg.mobidev_handsonrepo.activity_restaurant_workspace.S14_RestaurantActivity;
import com.neildg.mobidev_handsonrepo.activity_restaurant_workspace.S16_RestaurantActivity;

public class ChooseRestoWorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_resto_work);

        this.setupUI();
    }

    private void setupUI() {
     Button workOutputBtn = this.findViewById(R.id.work_output_btn);
     workOutputBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i = new Intent(ChooseRestoWorkActivity.this, RestaurantActivity.class);
             startActivity(i);
         }
     });

    Button mobidevBtn = this.findViewById(R.id.mobidev_s14_btn);
    mobidevBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(ChooseRestoWorkActivity.this, S14_RestaurantActivity.class);
            startActivity(i);
        }
    });

    Button wirtecBtn = this.findViewById(R.id.wirtec_s16_btn);
    wirtecBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(ChooseRestoWorkActivity.this, S16_RestaurantActivity.class);
            startActivity(i);
        }
    });

    }
}
