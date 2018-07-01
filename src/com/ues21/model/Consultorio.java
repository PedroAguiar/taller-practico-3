package com.ues21.model;

import com.ues21.structure.Cola;

import java.util.UUID;

public class Consultorio {
    private UUID uuid = UUID.randomUUID();
    private Cola pacientes = new Cola();

    public Consultorio() {
    }

    public Cola getPacientes() {
        return pacientes;
    }
}
