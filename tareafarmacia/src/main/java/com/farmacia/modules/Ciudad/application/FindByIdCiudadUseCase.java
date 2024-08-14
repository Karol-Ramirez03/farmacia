package com.farmacia.modules.Ciudad.application;

import java.util.Optional;

import com.farmacia.modules.Ciudad.domain.Service.CiudadService;
import com.farmacia.modules.Ciudad.domain.entity.Ciudad;

public class FindByIdCiudadUseCase {
    private CiudadService ciudadService;

    public FindByIdCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public Optional<Ciudad> execute(String codigociudad) {
        return ciudadService.findById(codigociudad);
    }
}
