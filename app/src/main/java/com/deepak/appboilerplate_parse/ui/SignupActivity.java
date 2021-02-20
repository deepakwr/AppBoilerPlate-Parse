package com.deepak.appboilerplate_parse.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.deepak.appboilerplate_parse.R;
import com.deepak.appboilerplate_parse.common.Alerts;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText edtEmail,edtUsername,edtPassword,edtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtEmail = findViewById(R.id.edtEmail);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);

    }


    public void signupPressed(View view){

        if(edtEmail.getText().length()>0
                && edtUsername.getText().length()>0
                && edtPassword.getText().length()>0
                && edtPassword.getText().toString().contentEquals(edtConfirmPassword.getText().toString())) {

            ParseUser user = new ParseUser();
            user.setEmail(edtEmail.getText().toString());
            user.setUsername(edtUsername.getText().toString());
            user.setPassword(edtPassword.getText().toString());

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null){
                        Alerts.toastMessage(SignupActivity.this,"Signup successfull");
                        ParseUser.logOutInBackground(new LogOutCallback() {
                            @Override
                            public void done(ParseException e) {
                                if(e == null){
                                    onBackPressed();
                                }else{
                                    Alerts.toastMessageLong(SignupActivity.this,e.getMessage());
                                }
                            }
                        });
                    }else{
                        Alerts.toastMessageLong(SignupActivity.this,e.getMessage());
                    }
                }
            });
        }
    }
}