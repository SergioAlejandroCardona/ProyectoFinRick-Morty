package com.example.proyecto_api_rickmorty.ApiManager;

import com.example.proyecto_api_rickmorty.Model.Episodios;
import com.example.proyecto_api_rickmorty.Model.Locaciones;
import com.example.proyecto_api_rickmorty.Model.Personajes;
import com.example.proyecto_api_rickmorty.ModelList.Episodios_list;
import com.example.proyecto_api_rickmorty.ModelList.Locaciones_list;
import com.example.proyecto_api_rickmorty.ModelList.Personajes_list;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "https://rickandmortyapi.com/api/";

    @GET("character")
    Call<Personajes_list> getPersonajeslist();

    @GET("character/{id}")
    Call<Personajes> getPersonaje(@Path("id") int id);

    @GET("location")
    Call<Locaciones_list> getLocacioneslist();

    @GET("location/{id}")
    Call<Locaciones> getLocacion(@Path("id") int id);

    @GET("episode")
    Call<Episodios_list> getEpisodioslist();

    @GET("episode/{id}")
    Call<Episodios> getEpisodio(@Path("id") int id);

}
