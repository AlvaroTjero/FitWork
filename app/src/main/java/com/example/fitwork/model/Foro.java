package com.example.fitwork.model;

public class Foro {

    private String uid;
    private String nombre;
    private String mensaje;

    public Foro() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {

        return  nombre + "\n " + mensaje;
    }
}
