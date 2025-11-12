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

    /**
     * Crea una cadena JSON a partir de los datos de la operación de inserción.
     * * @param dni El DNI del registro.
     * @param nombre El nombre del registro.
     * @param mensaje El mensaje de éxito o error.
     * @return Una cadena String con el JSON generado.
     */
  
    public String crearJson(String dni, String codAsig, boolean semestre1, boolean semestre2) {

        // Usamos un Map para estructurar los datos clave-valor.
        Map<String, Object> responseData = new HashMap<>();
        
        responseData.put("status", "SUCCESS");
        responseData.put("message", "todo correcto");
        responseData.put("data_inserted", true);
        responseData.put("dni", dni);
        responseData.put("Semestre1", semestre1);
        responseData.put("Semestre2", semestre2);
        responseData.put("Codigo", codAsig);

        
        // Convierte el Map completo a JSON String
        return gson.toJson(responseData);
       
    }
}
