package com.example.horizongamestore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://www.freetogame.com/api/";

    @GET("games")
    Call<List<Game>> getGames();
}
