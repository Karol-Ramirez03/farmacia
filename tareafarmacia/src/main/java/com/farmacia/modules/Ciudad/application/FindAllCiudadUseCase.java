package com.farmacia.modules.Ciudad.application;

import java.util.List;

import com.farmacia.modules.Ciudad.domain.Service.CiudadService;
import com.farmacia.modules.Ciudad.domain.entity.Ciudad;

public class FindAllCiudadUseCase {
    private CiudadService ciudadService;

    public FindAllCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public List<Ciudad> execute(){
        return ciudadService.findAllCiudad();
    }
}
