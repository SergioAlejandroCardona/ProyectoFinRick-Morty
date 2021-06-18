package com.example.proyecto_api_rickmorty.ModelList;

import com.example.proyecto_api_rickmorty.Model.Locaciones;
import com.example.proyecto_api_rickmorty.Model.Personajes;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Locaciones_list {

    @SerializedName("results")
    List<Locaciones> MylistResultLocaciones;

    public List<Locaciones> getMylistResultLocaciones() {
        return MylistResultLocaciones;
    }

    public void setMylistResultLocaciones(List<Locaciones> mylistResultLocaciones) {
        MylistResultLocaciones = mylistResultLocaciones;
    }
}
