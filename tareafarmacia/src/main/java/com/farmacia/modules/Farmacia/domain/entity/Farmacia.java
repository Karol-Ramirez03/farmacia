package com.farmacia.modules.Farmacia.domain.entity;

public class Farmacia {

    private int idf;
    private String nombreFarmacia;
    private String direccionFarmacia;
    private float longFarmacia;
    private float latFarmacia;
    private String codigoCiudadFarm;
    private String logoFarmacia;


    
    public Farmacia(String nombreFarmacia, String direccionFarmacia, float longFarmacia, float latFarmacia,
            String codigoCiudadFarm, String logoFarmacia) {
        this.nombreFarmacia = nombreFarmacia;
        this.direccionFarmacia = direccionFarmacia;
        this.longFarmacia = longFarmacia;
        this.latFarmacia = latFarmacia;
        this.codigoCiudadFarm = codigoCiudadFarm;
        this.logoFarmacia = logoFarmacia;
    }

    public Farmacia(int idf, String nombreFarmacia, String direccionFarmacia, float longFarmacia, float latFarmacia,
            String codigoCiudadFarm, String logoFarmacia) {
        this.idf = idf;
        this.nombreFarmacia = nombreFarmacia;
        this.direccionFarmacia = direccionFarmacia;
        this.longFarmacia = longFarmacia;
        this.latFarmacia = latFarmacia;
        this.codigoCiudadFarm = codigoCiudadFarm;
        this.logoFarmacia = logoFarmacia;
    }
    
    public int getIdf() {
        return idf;
    }
    public void setIdf(int idf) {
        this.idf = idf;
    }
    public String getNombreFarmacia() {
        return nombreFarmacia;
    }
    public void setNombreFarmacia(String nombreFarmacia) {
        this.nombreFarmacia = nombreFarmacia;
    }
    public String getDireccionFarmacia() {
        return direccionFarmacia;
    }
    public void setDireccionFarmacia(String direccionFarmacia) {
        this.direccionFarmacia = direccionFarmacia;
    }
    public float getLongFarmacia() {
        return longFarmacia;
    }
    public void setLongFarmacia(float longFarmacia) {
        this.longFarmacia = longFarmacia;
    }
    public float getLatFarmacia() {
        return latFarmacia;
    }
    public void setLatFarmacia(float latFarmacia) {
        this.latFarmacia = latFarmacia;
    }
    public String getCodigoCiudadFarm() {
        return codigoCiudadFarm;
    }
    public void setCodigoCiudadFarm(String codigoCiudadFarm) {
        this.codigoCiudadFarm = codigoCiudadFarm;
    }
    public String getLogoFarmacia() {
        return logoFarmacia;
    }
    public void setLogoFarmacia(String logoFarmacia) {
        this.logoFarmacia = logoFarmacia;
    }

    
}
