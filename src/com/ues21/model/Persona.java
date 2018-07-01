package com.ues21.model;

import java.util.UUID;

public abstract class Persona {

    private UUID uuid = UUID.randomUUID();
    private String nombre;
    private String appellido;

    public Persona() {
    }

    public Persona(String nombre, String appellido) {
        this.nombre = nombre;
        this.appellido = appellido;
    }

    public UUID getId() {
        return uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppellido() {
        return appellido;
    }

    public void setAppellido(String appellido) {
        this.appellido = appellido;
    }
}
