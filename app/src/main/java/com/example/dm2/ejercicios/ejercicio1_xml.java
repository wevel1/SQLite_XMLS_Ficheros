package com.example.dm2.ejercicios;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ejercicio1_xml extends AppCompatActivity {
    private List<Noticia> noticias;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio1_xml);
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute("http://www.europapress.es/rss/rss.aspx");
    }

    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserSax saxparser = new RssParserSax(params[0]);
            noticias= saxparser.parse();
            return true;
        }
        protected void onPostExecute(Boolean result) {
            AdaptadorNoticias adapter = new AdaptadorNoticias(ejercicio1_xml.this,(ArrayList<Noticia>)noticias);
            ListView listaNoticias = (ListView) findViewById(R.id.listaNoticias);
            listaNoticias.setAdapter(adapter);
        }
    }
}