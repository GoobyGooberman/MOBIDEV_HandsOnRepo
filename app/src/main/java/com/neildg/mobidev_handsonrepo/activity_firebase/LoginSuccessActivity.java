package com.neildg.mobidev_handsonrepo.activity_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.neildg.mobidev_handsonrepo.R;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

public class LoginSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        this.setupBtns();
        this.setupProfile();
    }

    private void setupProfile() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        TextView userNameTxt = this.findViewById(R.id.user_name_txt);
        userNameTxt.setText(user.getEmail());
    }

    private void setupBtns() {
        Button logoutBtn = this.findViewById(R.id.sign_out_btn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });
    }
}
