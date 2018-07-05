package com.ues21.model;

public class Paciente extends Persona implements Comparable {

    private ObraSocial obraSocial = ObraSocial.PARTICULAR;
    
    public Paciente() {
    }

    public Paciente(String nombre, String appellido, ObraSocial obraSocial, String dni) {
        super(nombre, appellido, dni);
        this.obraSocial = obraSocial;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
                .append("=[")
                .append("nombre= ")
                .append(this.getNombre())
                .append(", ")
                .append("apellido= ")
                .append(this.getApellido())
                .append(", ")
                .append("DNI= ")
                .append(this.getDNI())
                .append(", ")
                .append("obrasocial= ")
                .append(this.getObraSocial())
                .append("]")
                .toString();
    }

    @Override
    public int compareTo(Object o) {
        Paciente paciente = (Paciente) o;
        int thisDNI = Integer.valueOf(this.getDNI());
        int thatDNI = Integer.valueOf(paciente.getDNI());
        return Integer.compare(thisDNI, thatDNI);
    }


}
