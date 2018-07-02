package com.ues21.consultorio;

import com.ues21.model.Consultorio;
import com.ues21.service.PatientService;
import com.ues21.view.MenuView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CentroMedico {
    
    private static final List<Consultorio> CONSULTORIOS = Arrays.asList(
            new Consultorio("CENTRO"),
            new Consultorio("VILLA ALLENDE"),
            new Consultorio("ARGUELLO"),
            new Consultorio("URCA")
    );
    
    public static void init() {
        while (true) {
            MenuView.displayWelcomeForm();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    Consultorio consultorio = selectConsultorio();
                    MenuView.displayClientRegistrationForm();
                    PatientService.registerPatient(consultorio);
                break;
            }
        }
    }
    
    private static Consultorio selectConsultorio() {
        MenuView.displaySelectConsultiorioForm(CONSULTORIOS);
        Scanner scanner = new Scanner(System.in);
        final int option = scanner.nextInt();
        switch (option) {
            case 0:
                return CONSULTORIOS.get(0);
            case 1:
                return CONSULTORIOS.get(1);
            case 2:
                return CONSULTORIOS.get(2);
            case 3:
                return CONSULTORIOS.get(3);
            default:
                throw new IllegalArgumentException("Opcion no valida seleccion un consultorio valido");
        }
    }
}
