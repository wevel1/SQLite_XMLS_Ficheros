package com.example.dm2.ejercicios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LibroSQLiteHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE libro(isbn INTEGER PRIMARY KEY , titulo TEXT NOT NULL, autor TEXT)";

    public LibroSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS libro" );
        db.execSQL(sqlCreate);
    }
}
