package com.example.dm2.ejercicios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AdaptadorNoticias extends ArrayAdapter<Noticia> {
    private ArrayList<Noticia> noticias;
    public AdaptadorNoticias(Context context, ArrayList<Noticia> datos) {
        super(context, R.layout.item_noticia, datos);
        this.noticias =datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_noticia, null);

        TextView lblTitulo = (TextView) item.findViewById(R.id.lblTitulo);
        lblTitulo.setText(noticias.get(position).getTitulo());
        TextView lblLink = (TextView) item.findViewById(R.id.lblLink);
        lblLink.setText(noticias.get(position).getLink());
        TextView lblDescripcion = (TextView) item.findViewById(R.id.lblDescripcion);
        lblDescripcion.setText(noticias.get(position).getDescripcion());
        return(item);
    }
}