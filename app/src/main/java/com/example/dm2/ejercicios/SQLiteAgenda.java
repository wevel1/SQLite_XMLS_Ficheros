package com.example.dm2.ejercicios;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class SQLiteAgenda extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_agenda);
        AgendaSQLiteHelper usdbh = new AgendaSQLiteHelper(this, "DBAgenda" , null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        if (db != null){
            for (int i = 1; i<=10; i++){
                String nombre = "nombre " +i;
                int numero = 900+i;
                db.execSQL("INSERT INTO agenda(numero,nombre)" + " VALUES(" + numero  + ",'"+ nombre +"')" );
            }
            db.close();
        }
    }
}
