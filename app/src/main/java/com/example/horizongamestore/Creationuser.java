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

public class Creationuser extends AppCompatActivity {

    EditText fn,ln,un,reun,pass,repass;
    Button create;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_creationuser);

       
        
        fn = (EditText) findViewById(R.id.editTextTextPersonName3);
        ln = (EditText) findViewById(R.id.editTextTextPersonName4);
        un = (EditText) findViewById(R.id.editTextTextPersonName5);
        reun = (EditText) findViewById(R.id.editTextTextPersonName6);
        pass = (EditText) findViewById(R.id.editTextTextPersonName7);
        repass = (EditText) findViewById(R.id.editTextTextPersonName8);
        create = (Button) findViewById(R.id.button4);

        DatabaseHandler db1 = MainActivity.db;
        Intent homepage = new Intent(Creationuser.this, Homepage.class);

        
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                

            if(un.getText().toString().equals(reun.getText().toString()) && pass.getText().toString().equals(repass.getText().toString())){

                db1.addUser(new UserReg(fn.getText().toString() +" "+ ln.getText().toString() ,reun.getText().toString(),repass.getText().toString()));
                Toast.makeText(Creationuser.this, "Account Created", Toast.LENGTH_SHORT).show();
                String name = un.getText().toString();
                homepage.putExtra("Key", name);
                startActivity(homepage);
            }
            else{
                Toast.makeText(Creationuser.this, "Sorry passwords/username do not match", Toast.LENGTH_SHORT).show();
                clearBox();
            }




            }
        });
        
        
        
    }
    public void clearBox(){
        fn.getText().clear();
        ln.getText().clear();
        un.getText().clear();
        reun.getText().clear();
        pass.getText().clear();
        repass.getText().clear();
    }

}