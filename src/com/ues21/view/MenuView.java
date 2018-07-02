package com.ues21.view;

import com.ues21.model.Consultorio;
import com.ues21.model.ObraSocial;

import java.util.Arrays;
import java.util.List;

public class MenuView {
    
    public static void displayWelcomeForm() {
        System.out.println("Hola! Bienvenido a nuestro centro medico.");
        System.out.println("Si usted ya es un paciente registrado porfavor ingrese su numero de documento de lo contrario presion 1 para registrarse" +
                " o 0 para salir.");
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
    
    public static void displaySelectConsultiorioForm(List<Consultorio> consultorios) {
        System.out.println(String.format("Actualmente disponemos de %d consultorios.", consultorios.size()));
        System.out.println("Porfavor seleccione uno de los siguientes consultorios.");
        for(int index = 0; index < consultorios.size(); index++) {
            System.out.printf("Consultorio %d en %s \n", index, consultorios.get(index).getNombre());
        }
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
