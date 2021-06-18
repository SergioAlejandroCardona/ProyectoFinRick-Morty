package com.example.proyecto_api_rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyecto_api_rickmorty.Adapters.Personajes_adapter;
import com.example.proyecto_api_rickmorty.ApiManager.RetrofitClient;
import com.example.proyecto_api_rickmorty.ModelList.Personajes_list;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List_personajes extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listPersonajes;
    Personajes_list myPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_personajes);

        listPersonajes = findViewById(R.id.lvList_Personajes);

        getPersonajes();
        listPersonajes.setOnItemClickListener(this);
    }


    private void getPersonajes(){

        Call<Personajes_list> call = RetrofitClient.getInstance().getMyApi().getPersonajeslist();
        call.enqueue(new Callback<Personajes_list>() {
            @Override
            public void onResponse(Call<Personajes_list> call, Response<Personajes_list> response) {

                myPersonajes = response.body();

                Personajes_adapter adapterPersonajes = new Personajes_adapter(List_personajes.this, myPersonajes.getMylistResultPersonajes());
                listPersonajes.setAdapter(adapterPersonajes);

            }

            @Override
            public void onFailure(Call<Personajes_list> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent inPersonaje = new Intent(this, Personajes_Info.class);
        inPersonaje.putExtra("id_personaje", myPersonajes.getMylistResultPersonajes().get(position).getId());
        startActivity(inPersonaje);
    }


}