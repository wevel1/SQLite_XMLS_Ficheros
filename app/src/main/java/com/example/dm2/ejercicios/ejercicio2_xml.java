package com.example.dm2.ejercicios;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ejercicio2_xml extends AppCompatActivity {
    private List<Tiempo> tiempos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio2_xml);
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute("http://www.aemet.es/xml/municipios/localidad_01059.xml");
    }

    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserDom saxparser = new RssParserDom(params[0]);
            tiempos= saxparser.parse();
            return true;
        }
        protected void onPostExecute(Boolean result) {
            AdaptadorTiempo adapter = new AdaptadorTiempo(ejercicio2_xml.this,(ArrayList<Tiempo>)tiempos);

            ListView listaNoticias = (ListView) findViewById(R.id.listaTiempo);
            listaNoticias.setAdapter(adapter);
        }
    }

}