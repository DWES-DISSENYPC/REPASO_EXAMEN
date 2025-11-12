package com.ejemplo.services;

import java.io.*;
import java.nio.file.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class GestionMatriculaService {

    private static final long MAX_FILE_SIZE = 2 * 1024 * 1024; // 2MB
    private static final String CREDENCIALES_PATH = "/users.txt";

    /** Carga usuarios autorizados del archivo de recursos */
    public static Map<String, String> cargarCredenciales() {

        System.out.println("CREDENCIALES");

        Map<String, String> credenciales = new HashMap<>();
        try (InputStream in = GestionMatriculaService.class.getResourceAsStream(CREDENCIALES_PATH);
                BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2)
                    credenciales.put(partes[0].trim(), partes[1].trim());

            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error cargando credenciales: " + e.getMessage());
        }
        return credenciales;
    }

    /** Comprueba usuario y contraseña */
    public static boolean autenticarUsuario(String usuario, String contrasena) {
        System.out.println("AUTENTIFICACION");

        Map<String, String> credenciales = cargarCredenciales();
        return credenciales.containsKey(usuario)
                && credenciales.get(usuario).equals(contrasena);
    }

    /** Obtiene el nombre del fichero original */
    private static String getNombreFichero(Part fichero) {
        return Paths.get(fichero.getSubmittedFileName()).getFileName().toString();
    }

    /** Valida extensión */
    private static boolean validarExtension(String nombre) {
        return nombre != null && nombre.toLowerCase().endsWith(extEsperada.toLowerCase());
    }

    /** Valida tamaño leyendo el flujo (segura con cualquier contenedor) */
    private static boolean validarTamanyo(Part fichero) {
        long total = 0;
        try (InputStream in = fichero.getInputStream()) {
            byte[] buf = new byte[8192];
            int leidos;
            while ((leidos = in.read(buf)) != -1) {
                total += leidos;
                if (total > MAX_FILE_SIZE) {
                    System.out.println("Archivo demasiado grande (" + total + " bytes)");
                    return false;
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo fichero: " + e.getMessage());
            return false;
        }

        

        return true;
    }

   /*/ private static Part leerCampoTexto(HttpServletRequest req, String nombreCampo)
            throws IOException, ServletException {
        Part parte = req.getPart(nombreCampo);
        if (parte == null) {
            System.out.println("Campo '" + nombreCampo + "' no encontrado en la petición multipart.");
            return null;
        }
        return parte;
    }*/

    /** Procesa fichero: lo guarda en mayúsculas con nombre único 
     * @throws IOException 
     * @throws FileNotFoundException */
    public static boolean registrarMatricula(HttpServletRequest req) throws FileNotFoundException, IOException {

        try {

            System.err.println("=== ENTRANDO A procesarFichero ===");

            String dni = req.getParameter("dni");
            String email = req.getParameter("email");
            String codAsig = req.getParameter("codigo");
            String semestre = req.getParameter("semestre");

            if (!MatriculaBBDD.existeEstudiante(dni)) {
                System.err.println("Usuario no autorizado.");
                return false;
            }

            if (!MatriculaBBDD.asignaturaDisponible(codAsig, semestre)){

                System.err.println("La asignatura no está disponible");
                return false;
            }

            if (!ArchivoTxtService.asignaturaDisponible(codAsig, semestre)){

                System.err.println("La asignatura no está disponible");
                return false;
            }

            if (!MatriculaBBDD.insertarMatricula(dni, codAsig, semestre)) {

                System.err.println("Error al introducir los datos en la base de datos");
                return false;

            }

            return true;            

        } catch ( SQLException e) {
            System.err.println("Error en procesarFichero: " + e.getMessage());
            return false;
        }
    }
}
