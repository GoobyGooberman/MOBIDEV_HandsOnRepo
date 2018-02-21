package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.neildg.mobidev_handsonrepo.R;

public class S14_AddRestaurantActivity extends AppCompatActivity {
    private final static String TAG = "S14_AddRestaurant";

    public final static int ADD_REQUEST_CODE = 99;
    public final static String NAME_KEY = "NAME_KEY";
    public final static String DESC_KEY = "DESC_KEY";
    public final static String WEIGHT_KEY = "WEIGHT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s14_add_restaurant);

        this.setupButtons();
    }

    private void setupButtons() {
        Button cancelBtn = this.findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button submitBtn = this.findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we need to STORE our "data" before we finish the activity.
                onSubmitBtn();
                finish();
            }
        });
    }

    private void onSubmitBtn() {
        //get data from text fields
        EditText restoText = this.findViewById(R.id.resto_name_text);
        String name = restoText.getText().toString();

        EditText descText = this.findViewById(R.id.resto_desc_text);
        String desc = descText.getText().toString();

        EditText weightText = this.findViewById(R.id.weight_text);
        int weight = Integer.parseInt(weightText.getText().toString());

        //bundle data
        Intent resultIntent = new Intent();
        resultIntent.putExtra(NAME_KEY, name);
        resultIntent.putExtra(DESC_KEY, desc);
        resultIntent.putExtra(WEIGHT_KEY, weight);

        this.setResult(ADD_REQUEST_CODE, resultIntent);
    }

}
