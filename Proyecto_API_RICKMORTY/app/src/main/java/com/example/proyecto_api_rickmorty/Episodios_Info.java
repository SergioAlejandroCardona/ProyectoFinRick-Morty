package com.example.proyecto_api_rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_api_rickmorty.ApiManager.RetrofitClient;
import com.example.proyecto_api_rickmorty.Model.Episodios;
import com.example.proyecto_api_rickmorty.Model.Locaciones;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Episodios_Info extends AppCompatActivity {

    TextView IdEpiDet;
    TextView NombreEpiDet;
    TextView FechaEpiDet;
    TextView EpisodioEpiDet;
    TextView CreadoEpiDet;

    int IdEpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodios_info);

        IdEpiDet = findViewById(R.id.tvId_EpisodioDet);
        NombreEpiDet = findViewById(R.id.tvNombre_EpisodioDet);
        FechaEpiDet = findViewById(R.id.tvFechaAire_EpisodioDet);
        EpisodioEpiDet = findViewById(R.id.tvEpisodio_EpisodioDet);
        CreadoEpiDet = findViewById(R.id.tvCreado_EpisodioDet);

        Bundle in = getIntent().getExtras();
        IdEpi = in.getInt("id_episodio");
        getEpisodioById(IdEpi);

    }

    private void getEpisodioById(int idEpi) {

        Call<Episodios> call = RetrofitClient.getInstance().getMyApi().getEpisodio(idEpi);
        call.enqueue(new Callback<Episodios>() {
            @Override
            public void onResponse(Call<Episodios> call, Response<Episodios> response) {

                Episodios episodio = response.body();

                IdEpiDet.setText(String.valueOf(episodio.getId()));
                NombreEpiDet.setText(episodio.getName());
                FechaEpiDet.setText(episodio.getAir_date());
                EpisodioEpiDet.setText(episodio.getEpisode());
                CreadoEpiDet.setText(episodio.getCreated());

            }

            @Override
            public void onFailure(Call<Episodios> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}