 package com.farmacia.modules.UnidadMedida.application;

import com.farmacia.modules.UnidadMedida.domain.Service.UnidadMedidaService;

public class DeleteUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidadService;

    public DeleteUnidadMedidaUseCase(UnidadMedidaService unidadMedidadService) {
        this.unidadMedidadService = unidadMedidadService;
    }

    public void execute(int idum) {
        unidadMedidadService.deleteUnidadMedida(idum);
    }
    
}
