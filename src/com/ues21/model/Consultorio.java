package com.ues21.model;

import com.ues21.structure.ListaDoblementeEnlazada;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Consultorio {
    private UUID uuid = UUID.randomUUID();
    private String nombre;
    private ListaDoblementeEnlazada pacientes = new ListaDoblementeEnlazada();
    private List<Turno> turnos;

    public Consultorio() {
    }
    
    public Consultorio(String nombre) {
        this.nombre = nombre;
        this.turnos = new ArrayList<>();
    }
    
    public UUID getId() { return this.uuid; }
    
    public ListaDoblementeEnlazada getPacientes() {
        return this.pacientes;
    }
    
    public List<Turno> getTurnos() {
        return this.turnos;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return new StringBuilder("[" + this.getClass().getSimpleName() + ": ")
                .append("nombre= ").append(nombre).append(", ")
                .append("turnos= ").append(turnos.toString()).append("]")
                .toString();
    }
}
