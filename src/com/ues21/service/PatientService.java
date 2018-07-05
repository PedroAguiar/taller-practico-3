package com.ues21.service;

import com.ues21.model.Consultorio;
import com.ues21.model.ObraSocial;
import com.ues21.model.Paciente;
import com.ues21.model.exception.ObraSocialTypeNotFound;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.ues21.lib.Validate;

public class PatientService {
    
    
    
    public static String registerPatient(Consultorio consultorio) {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();
            List<String> parsedInput = parseInput(input);
            String nombre = parsedInput.get(0);
            String apellido = parsedInput.get(1);
            String dni = parsedInput.get(2);
            String obraSocialType =  parsedInput.get(3);
            validateRegisterPatientInput(nombre, apellido, dni, obraSocialType);
            return persistPatient(nombre, apellido, dni, ObraSocial.findObraSocialType(Integer.valueOf(obraSocialType)), consultorio);
        } catch (InputMismatchException | IllegalArgumentException | ObraSocialTypeNotFound e) {
            System.out.println(e.getMessage());
            return registerPatient(consultorio);
        }
    }
    
    private static String persistPatient(String nombre, String appellido, String dni, ObraSocial obraSocial, Consultorio consultorio) {
        Paciente patient = new Paciente(nombre, appellido, obraSocial, dni);
        consultorio.getPacientes().insertarOrdenado(patient);
        System.out.println("Se ha registrado exitosamente: " + patient.toString());
        return patient.getDNI();
    }
    
    private static List<String> parseInput(String input) {
        String[] splitInput = input.split(",");
        Validate.isTrue(splitInput.length == 4, "Datos invalidos, porfavor intentelo nuevamente.");
        String nombre = splitInput[0].trim();
        String apellido = splitInput[1].trim();
        String dni = splitInput[2].trim();
        String obraSocialType =  splitInput[3].trim();
        return Arrays.asList(nombre, apellido, dni, obraSocialType);
    }
    
    private static void validateRegisterPatientInput(String nombre, String apellido, String DNI, String obraSocialType)
            throws IllegalArgumentException, ObraSocialTypeNotFound {
        Validate.notBlank(nombre, "Datos invalidos, Porfavor intentelo nuevamente");
        Validate.notBlank(apellido, "Datos invalidos, Porfavor intentelo nuevamente");
        Validate.notBlank(DNI, "Datos invalidos, Porfavor intentelo nuevamente");
        Validate.containsOnlyLetters(new String[]{nombre, apellido});
        Validate.isDNI(DNI);
        ObraSocial.findObraSocialType(Integer.valueOf(obraSocialType));
    }
}
