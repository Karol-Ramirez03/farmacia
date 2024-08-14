package com.farmacia.modules.PrincipioActivo.application;

import java.util.List;

import com.farmacia.modules.PrincipioActivo.domain.Service.PrincipioActivoService;
import com.farmacia.modules.PrincipioActivo.domain.entity.PrincipioActivo;

public class FindAllPrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public FindAllPrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public List<PrincipioActivo> execute() {
        return principioActivoService.findAllPrincipioActivo();
    }
}
