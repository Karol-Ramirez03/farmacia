package com.farmacia.modules.PrincipioActivo.domain.entity;

public class PrincipioActivo {
    private int idpa;
    private String nombre;

    

    public PrincipioActivo(String nombre) {
        this.nombre = nombre;
    }
    
    public PrincipioActivo(int idpa, String nombre) {
        this.idpa = idpa;
        this.nombre = nombre;
    }
    public int getIdpa() {
        return idpa;
    }
    public void setIdpa(int idpa) {
        this.idpa = idpa;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
