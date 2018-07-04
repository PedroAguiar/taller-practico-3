package com.ues21.model;

import java.util.Date;

public class Turno {
    
    private String dni;
    private Date date;

    public Turno() {
    }

    public Turno(Date date) {
        this.date = date;
    }
    
    public Turno(String dni) {
        this.dni = dni;
        this.date = new Date();
    }
    
    public Turno(String dni, Date date) {
        this.dni = dni;
        this.date = date;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String toString() {
        return new StringBuilder("[")
                .append(this.getClass().getSimpleName() + ": ")
                .append("paciente= ")
                .append(this.dni)
                .append(", ")
                .append("fecha= ")
                .append(this.date.toString())
                .append(", ")
                .append("]")
                .toString();
    }
}
