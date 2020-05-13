package com.example.chiens.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chiens.R;

public class MainActivity extends AppCompatActivity {

    private Button button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =  findViewById(R.id.button_chiots);
        button1 = findViewById(R.id.button_mignon);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent i = new Intent (getApplicationContext(), RecyclerChiots.class);
                startActivity(i);
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent i = new Intent (getApplicationContext(), ChienMignon.class);
                startActivity(i);
                finish();
            }
        });
    }
}
