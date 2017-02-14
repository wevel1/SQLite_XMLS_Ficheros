package com.example.dm2.ejercicios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class AgendaSQLiteHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE agenda(numero INTEGER PRIMARY KEY ,"
            + " nombre TEXT NOT NULL)";

    public AgendaSQLiteHelper(Context contexto, String nombre,
                                CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS agenda" );
        db.execSQL(sqlCreate);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS agenda" );
        db.execSQL(sqlCreate);
    }
}

