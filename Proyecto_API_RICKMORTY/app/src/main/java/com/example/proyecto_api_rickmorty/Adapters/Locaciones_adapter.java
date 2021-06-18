package com.example.proyecto_api_rickmorty.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.proyecto_api_rickmorty.Model.Locaciones;
import com.example.proyecto_api_rickmorty.Model.Personajes;
import com.example.proyecto_api_rickmorty.R;

import java.util.List;

public class Locaciones_adapter extends BaseAdapter {

    protected Activity activity;
    protected List<Locaciones> locacionesList;

    public Locaciones_adapter(Activity activity, List<Locaciones> locacionesList) {
        this.activity = activity;
        this.locacionesList = locacionesList;
    }

    @Override
    public int getCount() {
        return locacionesList.size();
    }

    @Override
    public Object getItem(int position) {
        return locacionesList.get(position);
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
            v = inf.inflate(R.layout.locaciones_item, null);
        }

        Locaciones locacion = locacionesList.get(position);

        TextView Idlocacion = v.findViewById(R.id.tvIdLocacion);
        Idlocacion.setText(String.valueOf(locacion.getId()));

        TextView NombreLocacion = v.findViewById(R.id.tvNombreLocacion);
        NombreLocacion.setText(locacion.getName());

        TextView TipoLocacion = v.findViewById(R.id.tvTipoLocacion);
        TipoLocacion.setText(locacion.getType());

        return v;
    }
}
