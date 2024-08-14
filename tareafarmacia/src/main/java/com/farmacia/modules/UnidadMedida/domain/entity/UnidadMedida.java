package com.farmacia.modules.UnidadMedida.domain.entity;

public class UnidadMedida {
    private int idum;
    private String nombre;
    
    public UnidadMedida(int idum, String nombre) {
        this.idum = idum;
        this.nombre = nombre;
    }
    

    public UnidadMedida(String nombre) {
        this.nombre = nombre;
    }


    public int getIdum() {
        return idum;
    }

    public void setIdum(int idum) {
        this.idum = idum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
