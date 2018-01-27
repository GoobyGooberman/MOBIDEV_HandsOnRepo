package com.neildg.mobidev_handsonrepo.activity_restaurant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

public class AddRestaurantActivity extends AppCompatActivity {
    private final static String TAG = "AddRestaurantActivity";

    public final static int ACTIVITY_CODE = 1;
    public final static int ADD_SUCCESS = 1;
    public final static int ADD_FAILED = -1; //not really used.

    public final static String RESTAURANT_NAME_KEY = "RESTAURANT_NAME_KEY";
    public final static String RESTAURANT_DESC_KEY = "RESTAURANT_DESC_Key";
    public final static String WEIGHT_KEY = "WEIGHT_KEY";

    private EditText nameText;
    private EditText descText;
    private EditText weightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        this.nameText = this.findViewById(R.id.resto_name_text);
        this.descText = this.findViewById(R.id.resto_desc_text);
        this.weightText = this.findViewById(R.id.weight_text);

        this.setupButtons();
    }

    private void setupButtons() {
        Button cancelBtn = this.findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddRestaurantActivity.this.finish();
            }
        });

        Button submitBtn = this.findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AddRestaurantActivity.this.validateInput()) {
                    AddRestaurantActivity.this.bundleData();
                    AddRestaurantActivity.this.finish();
                }
            }
        });


    }

    private boolean validateInput() {
        if(this.nameText.getText().toString().length() == 0) {
            //dismiss keyboard so prompt can be seen.
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(this.nameText.getWindowToken(), 0);
            this.displayPrompt("Name cannot be blank.");
            return false;
        }

        if(this.descText.getText().toString().length() == 0) {
            //dismiss keyboard so prompt can be seen.
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(this.descText.getWindowToken(), 0);
            this.displayPrompt("Description cannot be blank.");
            return false;
        }

        //check weight
        int weight = -1;
        if(this.weightText.getText().toString().length() > 0) {
            weight = Integer.parseInt(AddRestaurantActivity.this.weightText.getText().toString());
        }

        if(weight <= 0 || weight > 50) {
            //dismiss keyboard so prompt can be seen.
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(weightText.getWindowToken(), 0);
            this.displayPrompt("Weight should be between 1 and 50.");
            return false;
        }

        return true;
    }

    /*
     * Bundles the data into an intent and sends it back to the previous activity who called it.
     */
    private void bundleData() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(RESTAURANT_NAME_KEY, this.nameText.getText().toString());
        resultIntent.putExtra(RESTAURANT_DESC_KEY, this.descText.getText().toString());
        resultIntent.putExtra(WEIGHT_KEY, Integer.parseInt(this.weightText.getText().toString()));
        this.setResult(ADD_SUCCESS, resultIntent);
    }

    private void displayPrompt(String message) {
        Snackbar snackbar = Snackbar.make(AddRestaurantActivity.this.findViewById(R.id.add_resto_layout), message,3000);

        TextView snackbarActionTextView =  snackbar.getView().findViewById( android.support.design.R.id.snackbar_text );
        snackbarActionTextView.setTextSize(20);
        snackbarActionTextView.setTypeface(snackbarActionTextView.getTypeface(), Typeface.BOLD);

        snackbar.show();
    }
}
