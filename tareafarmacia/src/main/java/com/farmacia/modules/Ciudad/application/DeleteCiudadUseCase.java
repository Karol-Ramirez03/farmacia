package com.farmacia.modules.Ciudad.application;

import com.farmacia.modules.Ciudad.domain.Service.CiudadService;

public class DeleteCiudadUseCase {
    private CiudadService ciudadService;

    public DeleteCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void execute(String codigociudad){
        ciudadService.deleteCiudad(codigociudad);
    }

}
