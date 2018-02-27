package com.neildg.mobidev_handsonrepo.activity_firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.neildg.mobidev_handsonrepo.R;

public class SignUpActivity extends AppCompatActivity {
    private final static String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.setupUI();
        this.setupBtns();
    }

    private void setupUI() {
        final View signupProgressBar = this.findViewById(R.id.signup_progress_layout);
        signupProgressBar.setVisibility(View.GONE);
    }

    private void setupBtns() {
        Button registerBtn = this.findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpActivity.this.attempSignUp();
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

    private void attempSignUp() {
        boolean result = true;
        View focusView = null;

        AutoCompleteTextView fullNameView = this.findViewById(R.id.full_name);
        String fullName = fullNameView.getText().toString();

        AutoCompleteTextView emailView = this.findViewById(R.id.email);
        String email = emailView.getText().toString();

        EditText passwordView = this.findViewById(R.id.password);
        String password = passwordView.getText().toString();

        EditText confirmPasswordView = this.findViewById(R.id.confirm_password);
        String confirmPassword = confirmPasswordView.getText().toString();

        //Check for valid name
        if(TextUtils.isEmpty(fullName)) {
            fullNameView.setError(getString(R.string.error_field_required));
            focusView = emailView;
            result = false;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailView.setError(getString(R.string.error_field_required));
            focusView = emailView;
            result = false;
        } else if (!LoginActivity.isEmailValid(email)) {
            emailView.setError(getString(R.string.error_invalid_email));
            focusView = emailView;
            result = false;
        }

        //check for password
        if(TextUtils.isEmpty(password)) {
            passwordView.setError("Password cannot be empty");
            focusView = passwordView;
            result = false;
        }

        if(TextUtils.isEmpty(confirmPassword)) {
            confirmPasswordView.setError("Confirm password cannot be empty");
            focusView = confirmPasswordView;
            result = false;
        }
        if (!TextUtils.isEmpty(password) && !LoginActivity.isPasswordValid(password)) {
            passwordView.setError(getString(R.string.error_invalid_password));
            focusView = passwordView;
            result = false;
        }

        if(!TextUtils.isEmpty(confirmPassword) && password.compareTo(confirmPassword) != 0) {
            confirmPasswordView.setError("Confirm password is not similar!");
            focusView = confirmPasswordView;
            result = false;
        }

        if(result) {
            //perform signup
            this.requestSignup(email, password);
        }
        else {
            focusView.requestFocus();
        }
    }

    private void requestSignup(String email, String password) {
       final View signupProgressBar = this.findViewById(R.id.signup_progress_layout);
       signupProgressBar.setVisibility(View.VISIBLE);

        final TextView registrationView = this.findViewById(R.id.registration_txt_view);
        registrationView.setVisibility(View.GONE);

        Task<AuthResult> authenResult = FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password);
        authenResult.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                signupProgressBar.setVisibility(View.INVISIBLE);
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success");
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    registrationView.setText("Registration success! New account created with email: " +user.getEmail());
                    registrationView.setVisibility(View.VISIBLE);

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    registrationView.setText("Registration failed! Message: " +task.getException());
                    registrationView.setVisibility(View.VISIBLE);

                }
            }
        });
    }
}
