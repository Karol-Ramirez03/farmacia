package com.farmacia.modules.PrincipioActivo.application;

import com.farmacia.modules.PrincipioActivo.domain.Service.PrincipioActivoService;
import com.farmacia.modules.PrincipioActivo.domain.entity.PrincipioActivo;


public class CreatePrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public CreatePrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public void execute(PrincipioActivo principioActivo) {
        principioActivoService.createPrincipioActivo(principioActivo);
    }
}
