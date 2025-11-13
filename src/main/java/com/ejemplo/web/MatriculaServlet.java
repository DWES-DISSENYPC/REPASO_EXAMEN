package com.ejemplo.web;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.ejemplo.modelo.Respuestas;
import com.ejemplo.services.GestionMatriculaService;

@WebServlet("/registro")
@MultipartConfig
public class MatriculaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Respuestas ok = GestionMatriculaService.registrarMatricula(req);

        // 2. Configurar la respuesta como JSON
        // Esto es crucial para que el cliente (ej. JavaScript) sepa qué esperar.
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // 3. Escribir el JSON en el cuerpo de la respuesta
        // El JSON se escribe independientemente de si 'ok' es true o false,
        // ya que el JSON contiene la información detallada del éxito o error.
        resp.getWriter().write(ok.getJsona());

      if (ok.getOk()) {
            // Éxito: Status 200 (OK)
            resp.setStatus(HttpServletResponse.SC_OK); 
            // NOTA: Ya no redirigimos, enviamos el JSON.
        } else {
            // Error: Status 400 (Bad Request) o 500 (Internal Server Error)
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
            // NOTA: Ya no redirigimos, enviamos el JSON de error.
        }
    }
}
