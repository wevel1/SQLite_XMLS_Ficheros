package com.example.dm2.ejercicios;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class AdaptadorWeb extends ArrayAdapter<Web> {
    private ArrayList<Web> datos;
    public AdaptadorWeb(Context context, ArrayList<Web> datos) {
        super(context, R.layout.item_web, datos);
        this.datos=datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_web, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.LblNombre);
        lblNombre.setText(datos.get(position).getNombre());

        TextView lblEnlace = (TextView)item.findViewById(R.id.LblEnlace);
        lblEnlace.setText(datos.get(position).getEnlace());

        ImageView lblimage = (ImageView)item.findViewById(R.id.Lblimagen);
        Bitmap bMap, bMapScaled;
        switch (datos.get(position).getLogo().toString().trim()) {
            case "bing":    bMap = BitmapFactory.decodeResource(getContext().getResources(),R.drawable.bing);
                bMapScaled = Bitmap.createScaledBitmap(bMap, 100, 100, true);
                lblimage.setImageBitmap(bMapScaled);
                break;
            case "yahoo":   bMap = BitmapFactory.decodeResource(getContext().getResources(),R.drawable.yahoo);
                bMapScaled = Bitmap.createScaledBitmap(bMap, 100, 100, true);
                lblimage.setImageBitmap(bMapScaled);
                break;
            case "google":  bMap = BitmapFactory.decodeResource(getContext().getResources(),R.drawable.google);
                bMapScaled = Bitmap.createScaledBitmap(bMap, 100, 100, true);
                lblimage.setImageBitmap(bMapScaled);
        }
        return(item);
    }
}