package com.example.fergu.androidlabs;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.data;
import static android.widget.Toast.LENGTH_SHORT;


public class StartActivity extends Activity {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    String messagePassed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In OnCreate()");
        Button startListItem = (Button) findViewById(R.id.button);


        startListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startActiv = new Intent(StartActivity.this, ListItemActivity.class);
                startActivityForResult(startActiv, 10);


            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In OnResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In OnStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In OnDestroy");

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 10) {
            String messagePassed = data.getStringExtra("Response");

            Toast.makeText(this, "ListItemsActivity passed: " + messagePassed, LENGTH_SHORT).show();
        }
    }

}
