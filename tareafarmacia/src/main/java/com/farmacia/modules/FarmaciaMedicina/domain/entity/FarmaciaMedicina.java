package com.farmacia.modules.FarmaciaMedicina.domain.entity;

public class FarmaciaMedicina {
    private int idFarmacia;
    private int idMedicinaFarm;
    private float precio;


    

    public FarmaciaMedicina(int idMedicinaFarm, float precio) {
        this.idMedicinaFarm = idMedicinaFarm;
        this.precio = precio;
    }

    public FarmaciaMedicina(int idFarmacia, int idMedicinaFarm, float precio) {
        this.idFarmacia = idFarmacia;
        this.idMedicinaFarm = idMedicinaFarm;
        this.precio = precio;
    }
    
    public int getIdFarmacia() {
        return idFarmacia;
    }
    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }
    public int getIdMedicinaFarm() {
        return idMedicinaFarm;
    }
    public void setIdMedicinaFarm(int idMedicinaFarm) {
        this.idMedicinaFarm = idMedicinaFarm;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
}
