package com.farmacia.modules.Ciudad.application;

import com.farmacia.modules.Ciudad.domain.Service.CiudadService;
import com.farmacia.modules.Ciudad.domain.entity.Ciudad;

public class UpdateCiudadUseCase {
    private CiudadService ciudadService;

    public UpdateCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }
    public void execute(Ciudad ciudad){
        ciudadService.updateCiudad(ciudad);

    }
}
