package com.example.horizongamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Homepage extends AppCompatActivity {
    TextView name;
    Button avail,sgame, cart, gr,pe,co,fs,ap,gnews, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_homepage);

        name = (TextView)findViewById(R.id.username);

        Intent intent = getIntent();

        String str = intent.getStringExtra("Key");
        String passss = intent.getStringExtra("Key2");

        name.setText("WELCOME "+str);

        avail = (Button) findViewById(R.id.av);
        sgame = (Button) findViewById(R.id.se);
        cart = (Button) findViewById(R.id.cart);
        gr = (Button) findViewById(R.id.gamer);
        pe = (Button) findViewById(R.id.pro);
        co = (Button) findViewById(R.id.check);
        fs = (Button) findViewById(R.id.location);
        ap = (Button) findViewById(R.id.appset);
        gnews = (Button) findViewById(R.id.gamenew);
        logout = (Button) findViewById(R.id.logout);


        Intent signin = new Intent(Homepage.this, MainActivity.class);
        Intent avg = new Intent(Homepage.this, availablagames.class);
        Intent sgam = new Intent(Homepage.this, searchact.class);
        Intent grr = new Intent(Homepage.this,Gamerev.class);
        Intent peee = new Intent(Homepage.this,ProfileEdit.class);
        Intent coo = new Intent(Homepage.this,Checkout.class);
        Intent fss = new Intent(Homepage.this,Findstores.class);
        Intent c = new Intent(Homepage.this,Cart.class);
        Intent aps = new Intent(Homepage.this,AppSettings.class);
        Intent gnewss = new Intent(Homepage.this,Gamenews.class);



        sgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(sgam);
            }
        });


        avail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(avg);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(c);
            }
        });
        gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(grr);
            }
        });
        pe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peee.putExtra("key1",passss);
                peee.putExtra("key2",str);
                startActivity(peee);
            }
        });
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(coo);
            }
        });
        fs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(fss);
            }
        });
        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(aps);
            }
        });
        gnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gnewss);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mysong.release();
                startActivity(signin);
            }
        });











    }
}