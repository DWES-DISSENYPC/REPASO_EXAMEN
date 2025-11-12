package com.ejemplo.modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Matricula {

    private String id_matricula;
    private String dni;
    private String codigo;
    private Semestres semestre;
    private LocalDate fechaRegistro;
    
    public Matricula(String id_matricula, String dni, String codigo, Semestres semestre) {
        this.id_matricula = id_matricula;
        this.dni = dni;
        this.codigo = codigo;
        this.semestre = semestre;
        this.fechaRegistro = LocalDate.now();
    }

    public String getId_matricula() {
        return id_matricula;
    }

    public String getDni() {
        return dni;
    }

    public String getCodigo() {
        return codigo;
    }

    

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setId_matricula(String id_matricula) {
        this.id_matricula = id_matricula;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setSemestre1(Semestres semestre1) {
        this.semestre = semestre1;
    }

    
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Matricula [id_matricula=" + id_matricula + ", dni=" + dni + ", codigo=" + codigo +  ", semestre=" + semestre + ", fechaRegistro=" + fechaRegistro + "]";
    }
    
    

    
}
