package com.ues21.model;

public class Paciente extends Persona {

    private String obraSocial = "Particular";
    private Turno turno;


    public Paciente() {
    }

    public Paciente(String nombre, String appellido, String obraSocial, Turno turno) {
        super(nombre, appellido);
        this.obraSocial = obraSocial;
        this.turno = turno;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
