package com.example.proyecto_api_rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_api_rickmorty.ApiManager.RetrofitClient;
import com.example.proyecto_api_rickmorty.Model.Locaciones;
import com.example.proyecto_api_rickmorty.Model.Personajes;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Locaciones_Info extends AppCompatActivity {

    TextView IdLocDet;
    TextView NombreLocDet;
    TextView TipoLocDet;
    TextView DimensionLocDet;
    TextView CreadoLocDet;

    int IdLoca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locaciones_info);

        IdLocDet = findViewById(R.id.tvId_LocacionDet);
        NombreLocDet = findViewById(R.id.tvNombre_LocacionDet);
        TipoLocDet = findViewById(R.id.tvTipo_LocacionDet);
        DimensionLocDet = findViewById(R.id.tvDimension_LocacionDet);
        CreadoLocDet = findViewById(R.id.tvCreado_LocacionDet);

        Bundle in = getIntent().getExtras();
        IdLoca = in.getInt("id_locacion");
        getLocacionById(IdLoca);

    }

    private void getLocacionById(int idLoca) {

        Call<Locaciones> call = RetrofitClient.getInstance().getMyApi().getLocacion(idLoca);
        call.enqueue(new Callback<Locaciones>() {
            @Override
            public void onResponse(Call<Locaciones> call, Response<Locaciones> response) {

                Locaciones locacion = response.body();

                IdLocDet.setText(String.valueOf(locacion.getId()));
                NombreLocDet.setText(locacion.getName());
                TipoLocDet.setText(locacion.getType());
                DimensionLocDet.setText(locacion.getDimension());
                CreadoLocDet.setText(locacion.getCreated());

            }

            @Override
            public void onFailure(Call<Locaciones> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}