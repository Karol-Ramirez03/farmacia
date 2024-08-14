package com.farmacia.modules.Ciudad.domain.entity;

public class Ciudad {
    private String codigociudad;
    private String nombreciudad;
    private String codigoreg;

    

    public Ciudad(String codigociudad, String nombreciudad, String codigoreg) {
        this.codigociudad = codigociudad;
        this.nombreciudad = nombreciudad;
        this.codigoreg = codigoreg;
    }

    public String getCodigociudad() {
        return codigociudad;
    }
    public void setCodigociudad(String codigociudad) {
        this.codigociudad = codigociudad;
    }
    public String getNombreciudad() {
        return nombreciudad;
    }
    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
    }
    public String getCodigoreg() {
        return codigoreg;
    }
    public void setCodigoreg(String codigoreg) {
        this.codigoreg = codigoreg;
    }

    
   
}
