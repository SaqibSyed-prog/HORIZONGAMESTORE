package com.example.horizongamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Modusername extends AppCompatActivity {
    Button con;
    EditText old, neww;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_modusername);

        con = (Button) findViewById(R.id.con);
        Intent intent = getIntent();
        String user = intent.getStringExtra("key1");
        String pass = intent.getStringExtra("key2");

        neww = (EditText) findViewById(R.id.newusername);
        String newuser = neww.getText().toString();
        DatabaseHandler db1 = MainActivity.db;


        List<UserReg> userlist = db1.getAllUsers();

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(UserReg u: userlist){

                    if(u.getUserName().equals(user) && u.getPassword().equals(pass)){
                        u.setUserName(newuser);
                    db1.updateUserReg(u);
                    }
                }
                Toast.makeText(Modusername.this, "Username has been modified", Toast.LENGTH_SHORT).show();
                Intent login = new Intent(Modusername.this, ProfileEdit.class);
                startActivity(login);




            }
        });

    }
}