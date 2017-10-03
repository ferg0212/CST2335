package com.example.fergu.androidlabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import static android.R.attr.data;
import static android.widget.Toast.LENGTH_SHORT;

public class ListItemActivity extends Activity {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageButton imgButton = null;
    Switch swit = null;
    CheckBox checkbox = null;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In OnCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);


        imgButton = (ImageButton) findViewById(R.id.imageButt);
        imgButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent takePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 if(takePhoto.resolveActivity(getPackageManager()) != null) {
                     startActivityForResult(takePhoto, REQUEST_IMAGE_CAPTURE);
                 }

                }

        });

        swit = (Switch) findViewById(R.id.swit);
        swit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swit.isChecked())
                    Toast.makeText(getApplicationContext() ,"Switch is On", Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(getApplicationContext(), "Switch is Off", Toast.LENGTH_LONG).show();

            }
        });

        checkbox = (CheckBox) findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if(checkbox.isChecked())
                    builder = new AlertDialog.Builder(ListItemActivity.this);
                    builder.setMessage(R.string.dialog_message);
                    builder.setTitle(R.string.dialog_title);
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                          Intent resultIntent = new Intent();
                            resultIntent.putExtra("Response", "Here is my response");
                            setResult(Activity.RESULT_OK, resultIntent);
                            finish();
                        }
                    });
                        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                            onResume();

                            }
                        }).show();






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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgButton.setImageBitmap(imageBitmap);
        }
    }



}
