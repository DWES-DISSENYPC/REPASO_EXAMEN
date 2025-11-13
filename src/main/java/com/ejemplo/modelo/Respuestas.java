package com.ejemplo.modelo;

public class Respuestas {

    private String json;
    private boolean ok;

    public Respuestas(boolean ok) {
        this.ok = ok;
    }


    public Respuestas(String json, boolean ok) {
        this.json = json;
        this.ok = ok;
    }

    
    public String getJsona() {
        return json;
    }
    public void setMatricula(String json) {
        this.json = json;
    }
    public boolean getOk() {
        return ok;
    }
    public void setOk(boolean ok) {
        this.ok = ok;
    }

    

    
    
}
