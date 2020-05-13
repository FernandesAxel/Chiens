package com.example.chiens.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChienAPI {

    @GET("api.json")
    Call<List<Chiots>> getChiens();

}