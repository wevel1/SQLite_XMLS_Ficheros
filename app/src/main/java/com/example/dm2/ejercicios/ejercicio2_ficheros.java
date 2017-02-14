package com.example.dm2.ejercicios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ejercicio2_ficheros extends AppCompatActivity {
    private ArrayList<String> datos= new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio2_ficheros);


        InputStream is = getResources().openRawResource(R.raw.ejercicio2_raw);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            String line = br.readLine();
            while (line!=null) {
                datos.add(line);
                line = br.readLine();
            }
            br.close();
            is.close();
        } catch (IOException e) {
        }

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

        Spinner spiner = (Spinner)findViewById(R.id.spinner);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spiner.setAdapter(adaptador);

    }
}
