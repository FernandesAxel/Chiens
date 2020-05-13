package com.example.chiens.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.chiens.Model.ChienMignonAdapter;
import com.example.chiens.R;

import java.util.ArrayList;

public class ChienMignon extends AppCompatActivity {

    private ArrayList<String> mText = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chien_mignon);

        initialisationImage();

    }

    private void initialisationImage(){

        mText.add("AKITA INU");
        mImages.add("https://static.toutoupourlechien.com/2019/10/race-akita-inu.jpg");

        mText.add("HUSKY SIBÉRIEN");
        mImages.add("https://static.toutoupourlechien.com/2019/06/race-cavalier-king-charles.jpg");

        mText.add("MALTESE");
        mImages.add("https://images.dog.ceo/breeds/maltese/n02085936_8089.jpg");

        mText.add("RETRIEVER");
        mImages.add("https://images.dog.ceo/breeds/retriever-flatcoated/n02099267_838.jpg");

        mText.add("DALMATIAN");
        mImages.add("https://images.dog.ceo/breeds/dalmatian/cooper2.jpg");

        mText.add("ROTTWEILER");
        mImages.add("https://images.dog.ceo/breeds/rottweiler/n02106550_10048.jpg");

        mText.add("FAIRY PUG");
        mImages.add("https://images.dog.ceo/breeds/pug/n02110958_14927.jpg");


        mText.add("DOBERMAN");
        mImages.add("https://images.dog.ceo/breeds/doberman/n02107142_18214.jpg");

        mText.add("APPENZELLER");
        mImages.add("https://images.dog.ceo/breeds/appenzeller/n02107908_4473.jpg");

        mText.add("AWESOME PUGGLE");
        mImages.add("https://images.dog.ceo/breeds/puggle/IMG_192117.jpg");

        mText.add("CATTLEDOG AUSTRALIAN");
        mImages.add("https://images.dog.ceo/breeds/cattledog-australian/IMG_2432.jpg");

        initRecycler();
    }

    private void initRecycler(){

        RecyclerView recyclerView = findViewById(R.id.recyclerView_chien_mignon);
        ChienMignonAdapter chienMignonAdapter = new ChienMignonAdapter(this,mImages,mText);
        recyclerView.setAdapter(chienMignonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
