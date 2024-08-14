package com.farmacia.modules.UnidadMedida.application;

import com.farmacia.modules.UnidadMedida.domain.Service.UnidadMedidaService;
import com.farmacia.modules.UnidadMedida.domain.entity.UnidadMedida;

public class CreateUnidadMedidadUseCase {
    private UnidadMedidaService unidadMedidadService;

    public CreateUnidadMedidadUseCase(UnidadMedidaService unidadMedidadService) {
        this.unidadMedidadService = unidadMedidadService;
    }

    public void execute(UnidadMedida unidadmedida) {
        unidadMedidadService.createUnidadMedida(unidadmedida);
    }
  

}
