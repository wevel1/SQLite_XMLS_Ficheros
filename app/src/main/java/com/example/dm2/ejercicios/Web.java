package com.example.dm2.ejercicios;

public class Web {
    private String nombre, enlace, logo, identificador;

    public Web() {
    }

    public Web(String nombre, String enlace, String logo, String identificador) {
        this.nombre = nombre;
        this.enlace = enlace;
        this.logo = logo;
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }
    public String getEnlace() {
        return enlace;
    }
    public String getLogo() {
        return logo;
    }
    public String getIdentificador() {
        return identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
