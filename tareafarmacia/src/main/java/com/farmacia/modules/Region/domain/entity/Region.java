package com.farmacia.modules.Region.domain.entity;

public class Region {
    private String codigoreg;
    private String nombrereg;
    private String codigopais;

    

    public Region(String codigoreg, String nombrereg, String codigopais) {
        this.codigoreg = codigoreg;
        this.nombrereg = nombrereg;
        this.codigopais = codigopais;
    }


    public String getCodigoreg() {
        return codigoreg;
    }
    public void setCodigoreg(String codigoreg) {
        this.codigoreg = codigoreg;
    }
    public String getNombrereg() {
        return nombrereg;
    }
    public void setNombrereg(String nombrereg) {
        this.nombrereg = nombrereg;
    }
    public String getCodigopais() {
        return codigopais;
    }
    public void setCodigopais(String codigopais) {
        this.codigopais = codigopais;
    }

}
