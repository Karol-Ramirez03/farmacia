package com.farmacia.modules.Pais.domain.entity;

public class Pais {
    private String nombre;
    private String codigopais;

    public Pais(String nombre, String codigopais) {
        this.nombre = nombre;
        this.codigopais = codigopais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigopais() {
        return codigopais;
    }

    public void setCodigopais(String codigopais) {
        this.codigopais = codigopais;
    }

}
