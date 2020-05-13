package com.example.chiens.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chiens.R;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        String image_url = getIntent().getStringExtra("image_url");
        String text = getIntent().getStringExtra("text");

        TextView race = findViewById(R.id.text_gallery);
        ImageView image = findViewById(R.id.image_gallery);

        race.setText(text);
        Glide.with(this).asBitmap().load(image_url).into(image);
    }
}
