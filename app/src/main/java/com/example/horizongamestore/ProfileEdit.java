package com.example.horizongamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProfileEdit extends AppCompatActivity {

    Button delete, epass,euser;
    ImageButton back;
    DatabaseHandler db1 = MainActivity.db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile_edit);

        Intent intent = getIntent();
       String str = intent.getStringExtra("key1");
       String strr = intent.getStringExtra("key2");


        delete = (Button) findViewById(R.id.deleteacc);
        back = (ImageButton) findViewById(R.id.back);
        epass = (Button)findViewById(R.id.modpass);
        euser = (Button)findViewById(R.id.modname);
        List<UserReg> userlist = db1.getAllUsers();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent login = new Intent(ProfileEdit.this, SignIn.class);
                for(UserReg u: userlist){

                    if(u.password.equals(str) && u.getUserName().equals(strr)){

                        db1.deleteUser(u);

                    }
                }


                Toast.makeText(ProfileEdit.this, "User Deleted", Toast.LENGTH_SHORT).show();
                startActivity(login);



            }
        });

        epass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(ProfileEdit.this,Modpass.class);
                next.putExtra("key1",strr);
                next.putExtra("key2",str);
                startActivity(next);
            }
        });
        euser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(ProfileEdit.this,Modusername.class);
                next.putExtra("key1",strr);
                next.putExtra("key2",str);
                startActivity(next);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(ProfileEdit.this,Homepage.class);
                startActivity(b);
            }
        });
    }
}