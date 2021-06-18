package com.example.proyecto_api_rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyecto_api_rickmorty.Adapters.Locaciones_adapter;
import com.example.proyecto_api_rickmorty.Adapters.Personajes_adapter;
import com.example.proyecto_api_rickmorty.ApiManager.RetrofitClient;
import com.example.proyecto_api_rickmorty.ModelList.Locaciones_list;
import com.example.proyecto_api_rickmorty.ModelList.Personajes_list;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List_locaciones extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listLocaciones;
    Locaciones_list myLocaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_locaciones);

        listLocaciones = findViewById(R.id.lvList_Locaciones);

        getLocaciones();
        listLocaciones.setOnItemClickListener(this);
    }

    private void getLocaciones() {

        Call<Locaciones_list> call = RetrofitClient.getInstance().getMyApi().getLocacioneslist();
        call.enqueue(new Callback<Locaciones_list>() {
            @Override
            public void onResponse(Call<Locaciones_list> call, Response<Locaciones_list> response) {

                myLocaciones = response.body();

                Locaciones_adapter adapterLocaciones = new Locaciones_adapter(List_locaciones.this, myLocaciones.getMylistResultLocaciones());
                listLocaciones.setAdapter(adapterLocaciones);

            }

            @Override
            public void onFailure(Call<Locaciones_list> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent inLocacion = new Intent(this, Locaciones_Info.class);
        inLocacion.putExtra("id_locacion", myLocaciones.getMylistResultLocaciones().get(position).getId());
        startActivity(inLocacion);
    }
}