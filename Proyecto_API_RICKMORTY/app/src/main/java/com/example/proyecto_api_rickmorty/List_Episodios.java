package com.example.proyecto_api_rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyecto_api_rickmorty.Adapters.Episodios_adapter;
import com.example.proyecto_api_rickmorty.ApiManager.RetrofitClient;
import com.example.proyecto_api_rickmorty.ModelList.Episodios_list;
import com.example.proyecto_api_rickmorty.ModelList.Locaciones_list;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List_Episodios extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listEpisodios;
    Episodios_list myEpisodios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_episodios);

        listEpisodios = findViewById(R.id.lvList_Episodios);

        getLocaciones();
        listEpisodios.setOnItemClickListener(this);
    }

    private void getLocaciones() {

        Call<Episodios_list> call = RetrofitClient.getInstance().getMyApi().getEpisodioslist();
        call.enqueue(new Callback<Episodios_list>() {
            @Override
            public void onResponse(Call<Episodios_list> call, Response<Episodios_list> response) {

                myEpisodios = response.body();

                Episodios_adapter adapterEpisodios = new Episodios_adapter(List_Episodios.this, myEpisodios.getMylistResultEpisodios());
                listEpisodios.setAdapter(adapterEpisodios);

            }

            @Override
            public void onFailure(Call<Episodios_list> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent inEpisodio = new Intent(this, Episodios_Info.class);
        inEpisodio.putExtra("id_episodio", myEpisodios.getMylistResultEpisodios().get(position).getId());
        startActivity(inEpisodio);
    }


}