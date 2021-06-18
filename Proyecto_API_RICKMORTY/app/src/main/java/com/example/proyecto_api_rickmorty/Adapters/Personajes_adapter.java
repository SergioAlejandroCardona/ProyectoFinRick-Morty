package com.example.proyecto_api_rickmorty.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.proyecto_api_rickmorty.Model.Personajes;
import com.example.proyecto_api_rickmorty.R;

import java.util.List;

public class Personajes_adapter extends BaseAdapter {

    protected Activity activity;
    protected List<Personajes> personajesList;

    public Personajes_adapter(Activity activity, List<Personajes> personajesList) {
        this.activity = activity;
        this.personajesList = personajesList;
    }

    @Override
    public int getCount() {
        return personajesList.size();
    }

    @Override
    public Object getItem(int position) {
        return personajesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null){

            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.personajes_item, null);
        }

        Personajes personaje = personajesList.get(position);

        TextView IdPersonaje = v.findViewById(R.id.tvId);
        IdPersonaje.setText(String.valueOf(personaje.getId()));

        TextView NombrePersonaje = v.findViewById(R.id.tvNombre);
        NombrePersonaje.setText(personaje.getName());

        TextView EspeciePersonaje = v.findViewById(R.id.tvEspecie);
        EspeciePersonaje.setText(personaje.getSpecies());

        TextView GeneroPersonaje = v.findViewById(R.id.tvGenero);
        GeneroPersonaje.setText(personaje.getGender());

        return v;
    }


}
