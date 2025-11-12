package com.ejemplo.modelo;

public class Estudiante {
    
    private String dni;
    private String nombre;
    private String email;
    private int telefono;


    public Estudiante(String dni, String email) {
        this.dni = dni;
        this.email = email;
    }


    public String getDni() {
        return dni;
    }


    public String getEmail() {
        return email;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     public int getTelefono() {
        return telefono;
    }


    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "Estudiante [dni=" + dni + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + "]";
    }


    

    

   
}
