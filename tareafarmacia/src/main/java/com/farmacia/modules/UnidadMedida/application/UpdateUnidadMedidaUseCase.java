package com.farmacia.modules.UnidadMedida.application;

import com.farmacia.modules.UnidadMedida.domain.Service.UnidadMedidaService;

public class UpdateUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidadService;

    public UpdateUnidadMedidaUseCase(UnidadMedidaService unidadMedidadService) {
        this.unidadMedidadService = unidadMedidadService;
    }

    public void execute(int id) {
        unidadMedidadService.updateUnidadMedida(id);
    }
}
