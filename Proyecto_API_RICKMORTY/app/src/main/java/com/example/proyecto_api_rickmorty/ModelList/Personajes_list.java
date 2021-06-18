package com.example.proyecto_api_rickmorty.ModelList;

import com.example.proyecto_api_rickmorty.Model.Personajes;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Personajes_list {

    @SerializedName("results")
    List<Personajes> MylistResultPersonajes;

    public List<Personajes> getMylistResultPersonajes() {
        return MylistResultPersonajes;
    }

    public void setMylistResultPersonajes(List<Personajes> mylistResultPersonajes) {
        MylistResultPersonajes = mylistResultPersonajes;
    }
}
