package com.farmacia.modules.PrincipioActivo.application;

import com.farmacia.modules.PrincipioActivo.domain.Service.PrincipioActivoService;

public class UpdatePrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public UpdatePrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }
    
    public void execute(int id) {
        principioActivoService.updatePrincipioActivo(id);
    }
}
