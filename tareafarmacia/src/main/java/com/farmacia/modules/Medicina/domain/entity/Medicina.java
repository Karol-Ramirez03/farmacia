package com.farmacia.modules.Medicina.domain.entity;

public class Medicina {
    private int id;
    private String proceedings;
    private String nombre;
    private String registroMedico;
    private String descripcion;
    private String descripcionCorto;
    private String nombreRol;
    private int codigoModoAdmin;
    private int codigoPrincActivo;
    private int codigoUnidadMedida;
    private int codigoLab;


    
    public Medicina(int id, String proceedings, String nombre, String registroMedico, String descripcion,
            String descripcionCorto, String nombreRol, int codigoModoAdmin, int codigoPrincActivo,
            int codigoUnidadMedida, int codigoLab) {
        this.id = id;
        this.proceedings = proceedings;
        this.nombre = nombre;
        this.registroMedico = registroMedico;
        this.descripcion = descripcion;
        this.descripcionCorto = descripcionCorto;
        this.nombreRol = nombreRol;
        this.codigoModoAdmin = codigoModoAdmin;
        this.codigoPrincActivo = codigoPrincActivo;
        this.codigoUnidadMedida = codigoUnidadMedida;
        this.codigoLab = codigoLab;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProceedings() {
        return proceedings;
    }
    public void setProceedings(String proceedings) {
        this.proceedings = proceedings;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRegistroMedico() {
        return registroMedico;
    }
    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcionCorto() {
        return descripcionCorto;
    }
    public void setDescripcionCorto(String descripcionCorto) {
        this.descripcionCorto = descripcionCorto;
    }
    public String getNombreRol() {
        return nombreRol;
    }
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public int getCodigoModoAdmin() {
        return codigoModoAdmin;
    }
    public void setCodigoModoAdmin(int codigoModoAdmin) {
        this.codigoModoAdmin = codigoModoAdmin;
    }
    public int getCodigoPrincActivo() {
        return codigoPrincActivo;
    }
    public void setCodigoPrincActivo(int codigoPrincActivo) {
        this.codigoPrincActivo = codigoPrincActivo;
    }
    public int getCodigoUnidadMedida() {
        return codigoUnidadMedida;
    }
    public void setCodigoUnidadMedida(int codigoUnidadMedida) {
        this.codigoUnidadMedida = codigoUnidadMedida;
    }
    public int getCodigoLab() {
        return codigoLab;
    }
    public void setCodigoLab(int codigoLab) {
        this.codigoLab = codigoLab;
    }   
}
