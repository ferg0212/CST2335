package com.example.fergu.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ResourceBundle;


public class LoginActivity extends Activity {

    protected static final String ACTIVITY_NAME = "LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In OnCreate()");
        SharedPreferences loginValues = getSharedPreferences("defaultEmail", MODE_PRIVATE);
        loginValues.getString("defaultEmail", "email@domain.com");
        Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener(){

            Bundle someInfo = new Bundle();
                    public void onClick(View v) {
                Intent startActiv = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(startActiv, someInfo);
            }
        });



    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In OnStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In OnResume()");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In OnPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In OnStop()");
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In OnDestroy()");

    }







}
