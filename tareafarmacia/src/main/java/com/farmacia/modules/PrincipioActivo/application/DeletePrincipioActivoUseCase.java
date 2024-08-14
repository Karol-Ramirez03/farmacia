package com.farmacia.modules.PrincipioActivo.application;

import com.farmacia.modules.PrincipioActivo.domain.Service.PrincipioActivoService;

public class DeletePrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public DeletePrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public void execute(int idup){
        principioActivoService.deletePrincipioActivo(idup);
    }
}
