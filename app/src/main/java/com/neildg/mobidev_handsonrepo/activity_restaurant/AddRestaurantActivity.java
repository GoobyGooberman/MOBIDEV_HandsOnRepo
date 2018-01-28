package com.neildg.mobidev_handsonrepo.activity_restaurant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.neildg.mobidev_handsonrepo.R;

public class AddRestaurantActivity extends AppCompatActivity {
    private final static String TAG = "AddRestaurantActivity";

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
        this.inputEditData();
    }

    private void setupButtons() {

    }

    private void inputEditData() {

    }

    private boolean validateInput() {
        return true;
    }

    /*
     * Bundles the data into an intent and sends it back to the previous activity who called it.
     */
    private void bundleData() {

    }

    private void displayPrompt(String message) {
        Snackbar snackbar = Snackbar.make(AddRestaurantActivity.this.findViewById(R.id.add_resto_layout), message,3000);

        TextView snackbarActionTextView =  snackbar.getView().findViewById( android.support.design.R.id.snackbar_text );
        snackbarActionTextView.setTextSize(20);
        snackbarActionTextView.setTypeface(snackbarActionTextView.getTypeface(), Typeface.BOLD);

        snackbar.show();
    }
}
