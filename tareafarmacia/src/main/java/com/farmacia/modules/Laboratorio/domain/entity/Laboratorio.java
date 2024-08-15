package com.farmacia.modules.Laboratorio.domain.entity;

public class Laboratorio {
    private int codigoLab;
    private String nombreLab;
    private String codigoCiudad;

    
    public Laboratorio(String nombreLab, String codigoCiudad) {
        this.nombreLab = nombreLab;
        this.codigoCiudad = codigoCiudad;
    }


    public Laboratorio(int codigoLab, String nombreLab, String codigoCiudad) {
        this.codigoLab = codigoLab;
        this.nombreLab = nombreLab;
        this.codigoCiudad = codigoCiudad;
    }


    public int getCodigoLab() {
        return codigoLab;
    }


    public void setCodigoLab(int codigoLab) {
        this.codigoLab = codigoLab;
    }


    public String getNombreLab() {
        return nombreLab;
    }


    public void setNombreLab(String nombreLab) {
        this.nombreLab = nombreLab;
    }


    public String getCodigoCiudad() {
        return codigoCiudad;
    }


    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    
}
