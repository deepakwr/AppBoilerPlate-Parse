package com.deepak.appboilerplate_parse.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.deepak.appboilerplate_parse.R;
import com.deepak.appboilerplate_parse.common.Alerts;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginPressed(View view){
        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        ParseUser.logInInBackground(edtUsername.getText().toString(), edtPassword.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user != null){
                    Alerts.toastMessage(LoginActivity.this,user.getUsername() + " Login successful");
                }else{
                    Alerts.toastMessage(LoginActivity.this,"Login failed : " +e.getMessage());
                }
            }
        });
    }

    public void signupPressed(View view){
        Intent intent = new Intent(this,SignupActivity.class);
        startActivity(intent);
    }
}