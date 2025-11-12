package com.ejemplo.modelo;

public class Asignatura {

    private String codigo;
    private String nombre;
    private boolean semestre1;
    private boolean semestre2;
    private int creditos;
    
    public Asignatura(String codigo, String nombre, boolean semestre1, boolean semestre2, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.semestre1 = semestre1;
        this.semestre2 = semestre2;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isSemestre1() {
        return semestre1;
    }

    public boolean isSemestre2() {
        return semestre2;
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

    public void setSemestre1(boolean semestre1) {
        this.semestre1 = semestre1;
    }

    public void setSemestre2(boolean semestre2) {
        this.semestre2 = semestre2;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + ", semestre1=" + semestre1 + ", semestre2="
                + semestre2 + ", creditos=" + creditos + "]";
    }

    
    
}
