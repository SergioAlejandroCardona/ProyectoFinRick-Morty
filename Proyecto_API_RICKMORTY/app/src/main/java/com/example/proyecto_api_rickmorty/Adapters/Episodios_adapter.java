package com.example.proyecto_api_rickmorty.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.proyecto_api_rickmorty.Model.Episodios;
import com.example.proyecto_api_rickmorty.Model.Locaciones;
import com.example.proyecto_api_rickmorty.R;

import java.util.List;

public class Episodios_adapter extends BaseAdapter {

    protected Activity activity;
    protected List<Episodios> episodiosList;

    public Episodios_adapter(Activity activity, List<Episodios> episodiosList) {
        this.activity = activity;
        this.episodiosList = episodiosList;
    }

    @Override
    public int getCount() {
        return episodiosList.size();
    }

    @Override
    public Object getItem(int position) {
        return episodiosList.get(position);
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
            v = inf.inflate(R.layout.episodios_item, null);
        }

        Episodios episodio = episodiosList.get(position);

        TextView IdEpisodio = v.findViewById(R.id.tvIdEpisodio);
        IdEpisodio.setText(String.valueOf(episodio.getId()));

        TextView NombreEpisodio = v.findViewById(R.id.tvNombreEpisodio);
        NombreEpisodio.setText(episodio.getName());

        return v;
    }
}
