package com.ejemplo.services;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servicio encargado de generar respuestas JSON.
 */
public class JsonService {

    private final Gson gson;

    public JsonService() {
        // Usa GsonBuilder para formatear el JSON de forma legible (pretty printing)
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

      
    public String crearJson(String dni, String codAsig, String semestre) {

        Map<String, String> matricula = new HashMap<>();

        matricula.put("DNI", dni);
        matricula.put("Codigo Asignatura", codAsig);
        matricula.put("Semestre", semestre);

        // Usamos un Map para estructurar los datos clave-valor.
       
        String jsonString = gson.toJson(matricula);

        return jsonString;
        
              
    }
}
