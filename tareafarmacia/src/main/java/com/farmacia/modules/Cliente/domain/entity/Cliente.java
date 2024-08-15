package com.farmacia.modules.Cliente.domain.entity;

import java.util.Date;

public class Cliente {
    private String idCliente;
    private String nombreCliente;
    private String lastNombreCliente;
    private String codigoCiudadCliente;
    private String emailCliente;
    private Date birthdate;
    private float lon;
    private float latitud;

    
    
    public Cliente(String idCliente, String nombreCliente, String lastNombreCliente, String codigoCiudadCliente,
            String emailCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.lastNombreCliente = lastNombreCliente;
        this.codigoCiudadCliente = codigoCiudadCliente;
        this.emailCliente = emailCliente;
    }

    public Cliente(String idCliente, String nombreCliente, String lastNombreCliente, String codigoCiudadCliente,
            String emailCliente, Date birthdate, float lon, float latitud) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.lastNombreCliente = lastNombreCliente;
        this.codigoCiudadCliente = codigoCiudadCliente;
        this.emailCliente = emailCliente;
        this.birthdate = birthdate;
        this.lon = lon;
        this.latitud = latitud;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getLastNombreCliente() {
        return lastNombreCliente;
    }

    public void setLastNombreCliente(String lastNombreCliente) {
        this.lastNombreCliente = lastNombreCliente;
    }

    public String getCodigoCiudadCliente() {
        return codigoCiudadCliente;
    }

    public void setCodigoCiudadCliente(String codigoCiudadCliente) {
        this.codigoCiudadCliente = codigoCiudadCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    
    
}
