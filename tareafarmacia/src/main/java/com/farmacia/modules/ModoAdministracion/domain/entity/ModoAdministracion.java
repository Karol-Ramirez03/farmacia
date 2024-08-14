package com.farmacia.modules.ModoAdministracion.domain.entity;

public class ModoAdministracion {
    private int idma;
    private String descripcion;

    
    public ModoAdministracion(String descripcion) {
        this.descripcion = descripcion;
    }


    public ModoAdministracion(int idma, String descripcion) {
        this.idma = idma;
        this.descripcion = descripcion;
    }


    public int getIdma() {
        return idma;
    }


    public void setIdma(int idma) {
        this.idma = idma;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    
}
