package com.ejemplo.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoTxtService {

    public static boolean asignaturaDisponible(String codigoAsignatura, String semestre) throws FileNotFoundException, IOException {


        try (BufferedReader br = new BufferedReader(new FileReader("asignaturas.txt"))){

            String linea;

            while ((linea = br.readLine()) != null) {
                
                String[] asignatura = linea.split(",");
                if (asignatura[0].equalsIgnoreCase(codigoAsignatura)) {

                    if (asignatura[1].equalsIgnoreCase(semestre)) {

                        return true;
                    }

                }


            }
            
        }

        return false;
    }
    
}
