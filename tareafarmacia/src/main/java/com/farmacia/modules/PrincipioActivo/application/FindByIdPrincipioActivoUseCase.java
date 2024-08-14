package com.farmacia.modules.PrincipioActivo.application;

import java.util.Optional;

import com.farmacia.modules.PrincipioActivo.domain.Service.PrincipioActivoService;
import com.farmacia.modules.PrincipioActivo.domain.entity.PrincipioActivo;

public class FindByIdPrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public FindByIdPrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }
    

    public Optional<PrincipioActivo> execute(int id) {
        return principioActivoService.findById(id);
    }
}
