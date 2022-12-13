package com.example.horizongamestore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class SignIn extends AppCompatActivity {

    Button signIn;
    EditText user, pass;
    Intent homepage1;
    Intent adminCon;
    DatabaseHandler db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signin);


        user = (EditText)findViewById(R.id.editTextTextPersonName);
        pass = (EditText)findViewById(R.id.editTextTextPersonName2);

        signIn = (Button) findViewById(R.id.button3);


        homepage1 = new Intent(SignIn.this, Homepage.class);
        adminCon = new Intent(SignIn.this, AdminCon.class);
        db1 = MainActivity.db;

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //admin
                String name = user.getText().toString();

                if(user.getText().toString().equals("BOB") && pass.getText().toString().equals("password")){

                    adminCon.putExtra("Key",name);
                    startActivity(adminCon);

                }else
                //user
               signin();




            }
        });

        ImageButton back = (ImageButton)findViewById(R.id.imageButton13);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(SignIn.this, MainActivity.class);
                MainActivity.mysong.release();
                startActivity(g);
            }
        });


    }
    private void signin(){

                if(true == db1.checkusernamepassword(user.getText().toString(), pass.getText().toString())){
                    Toast.makeText(SignIn.this, "Correct Username", Toast.LENGTH_SHORT).show();
                    String name = user.getText().toString();
                    String passs = pass.getText().toString();
                    homepage1.putExtra("Key",name);
                    homepage1.putExtra("Key2",passs);
                    startActivity(homepage1);

                }else{
                    Toast.makeText(SignIn.this, "Try again", Toast.LENGTH_SHORT).show();
                }

    }

}