package com.example.dm2.ejercicios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorTiempo extends ArrayAdapter<Tiempo> {
    private ArrayList<Tiempo> datos;
    public AdaptadorTiempo(Context context, ArrayList<Tiempo> datos) {
        super(context, R.layout.item_noticia, datos);
        this.datos=datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_tiempo, null);

        TextView lblDia = (TextView) item.findViewById(R.id.lblDia);
        lblDia.setText(datos.get(position).getDia());
        TextView lblMaxima = (TextView) item.findViewById(R.id.lblMaxima);
        lblMaxima.setText(datos.get(position).getMaxima());
        TextView lblMinima = (TextView) item.findViewById(R.id.lblMinima);
        lblMinima.setText(datos.get(position).getMinima());

        return(item);
    }
}
