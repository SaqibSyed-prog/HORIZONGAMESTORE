package com.example.horizongamestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class AppSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_app_settings);

        Button  dark,light, mute, turnon;



       ImageButton back = (ImageButton)findViewById(R.id.back);

       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent g = new Intent(AppSettings.this, Homepage.class);
               startActivity(g);
           }
       });


       dark = (Button) findViewById(R.id.darkmode);


       dark.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
           }
       });

       light = (Button) findViewById(R.id.lightmode);

       light.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
           }
       });

       mute = (Button)findViewById(R.id.turnoff);

       mute.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });

       turnon = (Button)findViewById(R.id.turnup);
       turnon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });











    }
}