package com.example.horizongamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class AdminCon extends AppCompatActivity {

    Button pfedit,ulist,store,gamenews, setting, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin_con);


        pfedit = (Button) findViewById(R.id.button20);
        ulist = (Button) findViewById(R.id.button17);
        store = (Button) findViewById(R.id.button18);
        gamenews = (Button) findViewById(R.id.button23);
        setting = (Button) findViewById(R.id.button25);
        logout = (Button) findViewById(R.id.button19);


        ulist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent adminpage = new Intent(AdminCon.this, Adminpage.class);

                startActivity(adminpage);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(AdminCon.this, MainActivity.class);

                startActivity(s);
            }
        });



    }
}