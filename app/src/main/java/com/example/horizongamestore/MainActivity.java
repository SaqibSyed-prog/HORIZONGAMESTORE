package com.example.horizongamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static com.example.horizongamestore.DatabaseHandler db;
    Button signIN,createAcc;
    public static MediaPlayer mysong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        mysong=MediaPlayer.create(MainActivity.this,R.raw.music);
        mysong.setLooping(true);
         db = new DatabaseHandler(this);

        //insert fake users

       // Log.d("Insert ", "Inserting ..");
        //db.addUser(new UserReg("ravi","BOB","password"));
        //db.addUser(new UserReg("james","GYMRAT","Hello"));
        //db.addUser(new UserReg("george","HATGUY","password123"));

       // Log.d("Reading: ", "Reading all contacts..");
        //List<UserReg> users = db.getAllUsers();

       // for(UserReg ur : users){
      //      String log = "id: " + ur.getId()+ ",Name: " + ur.getName() + ", UserName: " + ur.getUserName() + ", Password: " + ur.getPassword();
         //   Log.d("Name:", log);
       // }


        signIN = (Button) findViewById(R.id.button);
        createAcc = (Button) findViewById(R.id.button2);
        playIT();

        signIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);

                startActivity(intent);

            }
        });

        createAcc.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Creationuser.class);

                startActivity(intent);
            }
        }));



    }
    public static void playIT(){
        mysong.start();
    }

    public void onPause(){
        super.onPause();

    }


}