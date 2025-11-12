package com.ejemplo.modelo;

public class Asignatura {

    private String codigo;
    private String nombre;
    private Semestres semestre;
    private int creditos;
    
    public Asignatura(String codigo, String nombre, boolean semestre1, boolean semestre2, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        setSmestre(semestre1, semestre2);
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

   public Semestres getSemestre() {
       return semestre;
   }

    public int getCreditos() {
        return creditos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSmestre(boolean semestre1, boolean semestre2) {

        if (semestre1) this.semestre = Semestres.PRIMERO;

        else this.semestre = Semestres.SEGUNDO;
    }

    

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Asignatura [codigo=" + codigo + ", nombre=" + nombre +  ", semestre="
                + semestre + ", creditos=" + creditos + "]";
    }

    
    
}
