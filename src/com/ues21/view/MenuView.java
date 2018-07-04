package com.ues21.view;

import com.ues21.model.ObraSocial;
import com.ues21.structure.ListaDoblementeEnlazada;

public class MenuView {
    
    public static void displayWelcomeForm() {
        System.out.println("Hola! Bienvenido a nuestro centro medico.");
        System.out.println("Para registrarse presione 1, para listar los pacientes por consultorio presione 2 o presione 0 para salir.");
    }

    public static void displayClientRegistrationForm() {
        System.out.println("Porfavor escriba la siguiente informacion sparada por comas");
        System.out.println("1) Nombre");
        System.out.println("2) Apellido");
        System.out.println("3) DNI");
        System.out.println("4) Obra social, valores posibles: "  + printObraSocialTypes());
    }
    
    public static void displayClientUnregistrationForm() {
        System.out.println("Esperamos nuestro servicio haya sido de su agrado");
        System.out.println("Porfavor, provea su DNI para proceder");
    }
    
    public static void displaySelectConsultiorioForm(ListaDoblementeEnlazada consultorios) {
        System.out.println("Actualmente disponemos de 4 consultorios.");
        System.out.println("Porfavor seleccione uno de los siguientes consultorios.");
        consultorios.listarAscendente();
    }
    
    private static String printObraSocialTypes() {
        StringBuilder toReturn = new StringBuilder();
        for (ObraSocial tipo : ObraSocial.values()) {
            toReturn.append(tipo.name())
                    .append("(").append(String.valueOf(tipo.obraSocialId))
                    .append("), ");
        }
        return toReturn.toString();
    }
}
