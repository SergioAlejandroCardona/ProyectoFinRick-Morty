package com.example.proyecto_api_rickmorty.ModelList;

import com.example.proyecto_api_rickmorty.Model.Episodios;
import com.example.proyecto_api_rickmorty.Model.Personajes;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Episodios_list {

    @SerializedName("results")
    List<Episodios> MylistResultEpisodios;

    public List<Episodios> getMylistResultEpisodios() {
        return MylistResultEpisodios;
    }

    public void setMylistResultEpisodios(List<Episodios> mylistResultEpisodios) {
        MylistResultEpisodios = mylistResultEpisodios;
    }
}
