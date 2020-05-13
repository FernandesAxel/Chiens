package com.example.chiens.Controller;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.chiens.Model.ChienAPI;
import com.example.chiens.Model.Chiots;
import com.example.chiens.Model.ListChiotsAdapter;
import com.example.chiens.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;

import com.example.chiens.R;

public class RecyclerChiots extends AppCompatActivity {

    private final String BASE_URL = "";


    private RecyclerView recyclerView;
    private ListChiotsAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private SharedPreferences s;
    private Gson gson;
    private List<Chiots> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_chiots);

        gson = new GsonBuilder().setLenient().create();
        s = getSharedPreferences("Chiens ", Context.MODE_PRIVATE);



        List<Chiots> liste = cache();
        if(liste != null){
            showList(liste);
        }else{
            makeApiCall();
        }
    }

    private void showList(List<Chiots> listeC) {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ListChiotsAdapter(listeC,getApplicationContext());

        recyclerView.setAdapter(mAdapter);

    }

    private void makeApiCall(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ChienAPI clubApi = retrofit.create(ChienAPI.class);

        Call<List<Chiots>> call = clubApi.getChiens();

        call.enqueue(new Callback<List<Chiots>>() {
            @Override
            public void onResponse(Call<List<Chiots>> call, Response<List<Chiots>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    saveList(list);
                    showList(list);
                    Toast.makeText(getApplicationContext(), "API Success", Toast.LENGTH_SHORT).show();

                } else {
                    showError();
                }
            }

            @Override
            public void onFailure(Call<List<Chiots>> call, Throwable t) {
                showError();
            }
        });
    }

    private void saveList(List<Chiots> list){

        String jsonString  = gson.toJson(list);

        s.edit().putString("jsonString",jsonString).apply();


    }
    private List<Chiots> cache(){

        String jsonChiots = s.getString("jsonString",null);
        if(jsonChiots == null){
            return null;
        }else{
            Type listeType = new TypeToken<List<Chiots>>(){}.getType();
            return gson.fromJson(jsonChiots,listeType);
        }


    }






    private void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }
}
