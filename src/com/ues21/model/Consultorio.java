package com.ues21.model;

import com.ues21.structure.Cola;

import java.util.List;
import java.util.UUID;

public class Consultorio {
    private UUID uuid = UUID.randomUUID();
    private String nombre;
    private Cola pacientes = new Cola();
    private List<Turno> turnos;

    public Consultorio() {
    }
    
    public Consultorio(String nombre) {
        this.nombre = nombre;
    }
    
    public UUID getId() { return this.uuid; }
    
    public Cola getPacientes() {
        return this.pacientes;
    }
    
    public List<Turno> getTurnos() {
        return this.turnos;
    }
    
    public String getNombre() {
        return nombre;
    }
}
