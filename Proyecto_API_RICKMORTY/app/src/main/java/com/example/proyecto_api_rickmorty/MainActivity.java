package com.example.proyecto_api_rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btPersonajes;
    Button btLocaciones;
    Button btEpisodios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btPersonajes = findViewById(R.id.btnPersonajes);
        btLocaciones = findViewById(R.id.btnLocaciones);
        btEpisodios = findViewById(R.id.btnEpisodios);

        btPersonajes.setOnClickListener(this);
        btLocaciones.setOnClickListener(this);
        btEpisodios.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnPersonajes){
            Intent intentListPersonajes = new Intent(this, List_personajes.class);
            startActivity(intentListPersonajes);
        }
        if (v.getId() == R.id.btnLocaciones){
            Intent intentListLocaciones = new Intent(this, List_locaciones.class);
            startActivity(intentListLocaciones);
        }
        if (v.getId() == R.id.btnEpisodios){
            Intent intentListEpisodios = new Intent(this, List_Episodios.class);
            startActivity(intentListEpisodios);
        }
    }


}