package com.example.horizongamestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class availablagames extends AppCompatActivity {
    private RecyclerView rv;
    private List<Game> gameList;
    private static final String TAG = "availablegames";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablagames);
        rv = findViewById(R.id.gameview);
        gameList = new ArrayList<>();
        getGames();

        ImageButton back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(availablagames.this, Homepage.class);
                startActivity(g);
            }
        });
    }

    private void showData(List<Game> body) {
        gameRecyclerViewAdapter adapter = new gameRecyclerViewAdapter(this, body);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(availablagames.this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }

    private void getGames() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Game>> call = api.getGames();

        call.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                Log.e(TAG, "onResponse: " + response.body());
                showData(response.body());
            }
            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}