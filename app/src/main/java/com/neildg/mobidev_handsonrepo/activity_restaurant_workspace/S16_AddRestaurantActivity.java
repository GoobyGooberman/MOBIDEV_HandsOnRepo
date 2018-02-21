package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

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

public class S16_AddRestaurantActivity extends AppCompatActivity {
    private final static String TAG = "AddRestoActivity";

    public final static int ADD_REQUEST_CODE = 69;

    public final static int ADD_SUCCESS_CODE = 24;
    public final static int ADD_FAILURE_CODE = 66;

    public final static String NAME_KEY = "NAME_KEY";
    public final static String DESC_KEY = "DESC_KEY";
    public final static String WEIGHT_KEY = "WEIGHT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s16_add_restaurant);

        this.setupButtons();
    }

    private void setupButtons() {
        Button submitBtn = this.findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSubmitEvent(v) == true){
                    finish();
                }

            }
        });

        Button cancelBtn = this.findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean onSubmitEvent(View v) {

        boolean bool;

        EditText nameText = this.findViewById(R.id.resto_name_text);
        String name = nameText.getText().toString();

        EditText descText = this.findViewById(R.id.resto_desc_text);
        String desc = descText.getText().toString();

        EditText weightText = this.findViewById(R.id.weight_text);
        String weight_tempo = weightText.getText().toString();


        Log.d(TAG, "Name:" +name+ " Desc: " +desc+ " Weight: " +weight_tempo);
        if(name.equals("")){
            this.showSnackbarMessage("Restaurant Name cannot be empty");
            bool = false;
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(nameText.getWindowToken(), 0);

            return bool;
        }
        else if(desc.equals("")){
            this.showSnackbarMessage("Description cannot be empty");
            bool = false;
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(descText.getWindowToken(), 0);
            return bool;
        }
        else if(weight_tempo.equals("")){
            this.showSnackbarMessage("Weight cannot be empty");
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(weightText.getWindowToken(),0);
            bool = false;
            return bool;
        }
        else if(Integer.parseInt(weight_tempo)< 1 || Integer.parseInt(weight_tempo) > 50){
            this.showSnackbarMessage("Weight must be greater than 0 and less than 50");
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(weightText.getWindowToken(),0);
            bool = false;
            return bool;
        }
        else{
            int weight = Integer.parseInt(weightText.getText().toString());
            Log.d(TAG, "Name:" +name+ " Desc: " +desc+ " Weight: " +weight);
            //bundle our data
            Intent bundleIntent = new Intent();
            bundleIntent.putExtra(NAME_KEY, name);
            bundleIntent.putExtra(DESC_KEY, desc);
            bundleIntent.putExtra(WEIGHT_KEY, weight);

            this.setResult(ADD_SUCCESS_CODE, bundleIntent);
            bool = true;
            return bool;
        }

    }

    private void showSnackbarMessage(String message) {
        Snackbar snackbar = Snackbar.make(S16_AddRestaurantActivity.this.findViewById(R.id.add_parent_layout),message,3000);

        TextView snackbarActionTextView =  snackbar.getView().findViewById( android.support.design.R.id.snackbar_text );
        snackbarActionTextView.setTextSize( 30 );
        snackbarActionTextView.setTypeface(snackbarActionTextView.getTypeface(), Typeface.BOLD);

        snackbar.show();
    }
}



