package com.ues21.consultorio;

import com.ues21.model.Consultorio;
import com.ues21.model.Turno;
import com.ues21.service.PatientService;
import com.ues21.structure.ListaDoblementeEnlazada;
import com.ues21.structure.NodoDoble;
import com.ues21.view.MenuView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CentroMedico {
    
    private static final ListaDoblementeEnlazada CONSULTORIOS = new ListaDoblementeEnlazada();
    
    static {
        CONSULTORIOS.insertar(new Consultorio("CENTRO"));
        CONSULTORIOS.insertarUltimo(new Consultorio("VILLA ALLENDE"));
        CONSULTORIOS.insertarUltimo(new Consultorio("ARGUELLO"));
        CONSULTORIOS.insertarUltimo(new Consultorio("URCA"));
    }
    
    public static void init() {
        while (true) {
            MenuView.displayWelcomeForm();
            Scanner scanner = new Scanner(System.in);
            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        Consultorio consultorio = selectConsultorio();
                        MenuView.displayClientRegistrationForm();
                        String dni = PatientService.registerPatient(consultorio);
                        consultorio.getTurnos().add(new Turno(dni));
                        break;
                    case 2:
                        listarPacientesPorConsultorio();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Opcion invalida, porfavor intentelo nuevamente.");
                }
            } catch (InputMismatchException e) {
                init();
                return;
            }
        }
    }
    
    private static Consultorio selectConsultorio() {
        MenuView.displaySelectConsultiorioForm(CONSULTORIOS);
        Scanner scanner = new Scanner(System.in);
        final int option = scanner.nextInt();
        try {
            switch (option) {
                case 0:
                    return (Consultorio) CONSULTORIOS.getInicio().getDato();
                case 1:
                    return (Consultorio) CONSULTORIOS.getInicio().getNext().getDato();
                case 2:
                    return (Consultorio) CONSULTORIOS.getInicio().getNext().getNext().getDato();
                case 3:
                    return (Consultorio) CONSULTORIOS.getInicio().getNext().getNext().getNext().getDato();
                default:
                    throw new IllegalArgumentException("Opcion no valida seleccion un consultorio valido");
            }
        } catch (IllegalArgumentException e) {
            return selectConsultorio();
        }
    }
    
    
    private static void listarPacientesPorConsultorio() {
        NodoDoble aux = CONSULTORIOS.getInicio();
        while (aux != null) {
            Consultorio consultorio = (Consultorio) aux.getDato();
            System.out.println("Consultorio: " + consultorio.getNombre());
            consultorio.getPacientes().listarAscendente();
            aux = aux.getNext();
        }
    }
}
