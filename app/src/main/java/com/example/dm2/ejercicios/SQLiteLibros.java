package com.example.dm2.ejercicios;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SQLiteLibros extends AppCompatActivity {
    private SQLiteDatabase db;
    private String consulta;
    private EditText etxtISBN, etxtTitulo, etxtAutor;
    private TextView txtConsulta;

    void insertar(View v) {
        etxtISBN = (EditText) findViewById(R.id.etxtISBN);
        etxtTitulo = (EditText) findViewById(R.id.etxtTitulo);
        etxtAutor = (EditText) findViewById(R.id.etxtAutor);

        if((!etxtISBN.getText().toString().equals(""))&&(!etxtTitulo.getText().toString().equals(""))){
            int isbn = Integer.parseInt(etxtISBN.getText().toString());
            String titulo = etxtTitulo.getText().toString();
            String autor = etxtAutor.getText().toString();
            if(autor.equals(""))
                consulta="INSERT INTO libro(isbn,titulo) VALUES("+isbn+",'"+titulo.toUpperCase()+"')";
            else
                consulta="INSERT INTO libro(isbn,titulo,autor) VALUES("+isbn+",'"+titulo.toUpperCase()+"','"+autor.toUpperCase()+"')";

            db.execSQL(consulta);
            etxtISBN.setText("");
            etxtTitulo.setText("");
            etxtAutor.setText("");
            Toast.makeText(this,"Libro insertado",Toast.LENGTH_SHORT).show();
            consultar(v);
        }
        else
            Toast.makeText(this,"El ISBN y el titulo no pueden estar vacios",Toast.LENGTH_SHORT).show();
    }
    void actualizar(View v) {
        etxtISBN = (EditText) findViewById(R.id.etxtISBN);
        etxtTitulo = (EditText) findViewById(R.id.etxtTitulo);
        etxtAutor = (EditText) findViewById(R.id.etxtAutor);

        if(!etxtISBN.getText().toString().equals("")) {
            int isbn=Integer.parseInt(etxtISBN.getText().toString());
            String titulo = etxtTitulo.getText().toString();
            String autor = etxtAutor.getText().toString();

            if(titulo.equals("")&&autor.equals(""))
                Toast.makeText(this,"No se ha modificado el libro, inserte nuevos datos",Toast.LENGTH_SHORT).show();
            else {
                if (!titulo.equals("") && !autor.equals(""))
                    consulta = "UPDATE libro SET titulo='" + titulo.toUpperCase() + "',autor='" + autor.toUpperCase() + "' where isbn=" + isbn;
                else {
                    if (titulo.equals(""))
                        consulta = "UPDATE libro SET autor='" + autor.toUpperCase() + "' where isbn=" + isbn;
                    if (autor.equals(""))
                        consulta = "UPDATE libro SET titulo='" + titulo.toUpperCase() + "' where isbn=" + isbn;
                }
                db.execSQL(consulta);
                etxtISBN.setText("");
                etxtTitulo.setText("");
                etxtAutor.setText("");
                consultar(v);
            }
        }
        else
            Toast.makeText(this,"Para actualizar un libro debes insertar su ISBN y los nuevos datos",Toast.LENGTH_SHORT).show();
    }
    void eliminar(View v) {
        etxtISBN = (EditText) findViewById(R.id.etxtISBN);
        if(!etxtISBN.getText().toString().equals("")) {
            int isbn = Integer.parseInt(etxtISBN.getText().toString());
            consulta="DELETE FROM LIBRO WHERE isbn="+isbn;
            db.execSQL(consulta);
            Toast.makeText(this,"Libro eliminado",Toast.LENGTH_SHORT).show();
            etxtISBN.setText("");
            consultar(v);
        }
        else
            Toast.makeText(this,"Introduce el isbn del libro que desa eliminar",Toast.LENGTH_SHORT).show();
    }
    void consultar(View v) {
        txtConsulta = (TextView) findViewById(R.id.txtConsulta);
        String datos = "";
        consulta="SELECT isbn,titulo,autor FROM libro";
        Cursor c =db.rawQuery(consulta,null);
        if(c.moveToFirst()) {
            do {
                if(c.getString(2)==null)
                    datos+=c.getInt(0)+" - Titulo: "+c.getString(1)+"\n";
                else
                    datos+=c.getInt(0)+" - Titulo: "+c.getString(1)+", Autor:"+c.getString(2)+"\n";
            } while (c.moveToNext());
            txtConsulta.setText(datos);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_libros);
        LibroSQLiteHelper usdbh = new LibroSQLiteHelper(this, "DBLibro" , null, 1);
        db = usdbh.getWritableDatabase();

    }
}
