package com.ejemplo.modelo;

import java.sql.Date;

public class Matricula {

    private String id_matricula;
    private String dni;
    private String codigo;
    private boolean semestre1;
    private boolean semestre2;
    private Date fechaRegistro;
    
    public Matricula(String ultimo_id_matricula, String dni, String codigo, boolean semestre1, boolean semestre2,
            Date fechaRegistro) {
        this.id_matricula = ultimo_id_matricula + 1;
        this.dni = dni;
        this.codigo = codigo;
        this.semestre1 = semestre1;
        this.semestre2 = semestre2;
        this.fechaRegistro = fechaRegistro;
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

    public boolean isSemestre1() {
        return semestre1;
    }

    public boolean isSemestre2() {
        return semestre2;
    }

    public Date getFechaRegistro() {
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

    public void setSemestre1(boolean semestre1) {
        this.semestre1 = semestre1;
    }

    public void setSemestre2(boolean semestre2) {
        this.semestre2 = semestre2;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Matricula [id_matricula=" + id_matricula + ", dni=" + dni + ", codigo=" + codigo + ", semestre1="
                + semestre1 + ", semestre2=" + semestre2 + ", fechaRegistro=" + fechaRegistro + "]";
    }
    
    

    
}
