package com.ues21.model;

import java.util.UUID;

public abstract class Persona {

    private UUID uuid = UUID.randomUUID();
    private String nombre;
    private String apellido;
    private String DNI;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = dni;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getDNI() {
        return DNI;
    }
    
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
