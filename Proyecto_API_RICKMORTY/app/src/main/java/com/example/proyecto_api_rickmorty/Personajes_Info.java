package com.example.proyecto_api_rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_api_rickmorty.ApiManager.RetrofitClient;
import com.example.proyecto_api_rickmorty.Model.Personajes;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Personajes_Info extends AppCompatActivity {

    ImageView imgpersonaje;
    TextView tvIddet;
    TextView tvNombredet;
    TextView tvEstadodet;
    TextView tvEspeciedet;
    TextView tvGenerodet;

    int IdPers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes_info);

        imgpersonaje = findViewById(R.id.imgPersonaje);
        tvIddet = findViewById(R.id.tvId_details);
        tvNombredet = findViewById(R.id.tvNombre_details);
        tvEstadodet = findViewById(R.id.tvEstado_details);
        tvEspeciedet = findViewById(R.id.tvEspecie_details);
        tvGenerodet = findViewById(R.id.tvGenero_details);

        Bundle in = getIntent().getExtras();
        IdPers = in.getInt("id_personaje");
        getPersonajeById(IdPers);

    }

    private void getPersonajeById(int idPers) {

        Call<Personajes> call = RetrofitClient.getInstance().getMyApi().getPersonaje(idPers);
        call.enqueue(new Callback<Personajes>() {
            @Override
            public void onResponse(Call<Personajes> call, Response<Personajes> response) {

                Personajes personaje = response.body();

                Picasso.get()
                        .load(personaje.getImage())
                        .error(R.drawable.fondo_items)
                        .into(imgpersonaje);

                tvIddet.setText(String.valueOf(personaje.getId()));
                tvNombredet.setText(personaje.getName());
                tvEstadodet.setText(personaje.getStatus());
                tvEspeciedet.setText(personaje.getSpecies());
                tvGenerodet.setText(personaje.getGender());
            }

            @Override
            public void onFailure(Call<Personajes> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}