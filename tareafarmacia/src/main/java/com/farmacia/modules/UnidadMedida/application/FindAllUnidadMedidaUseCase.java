package com.farmacia.modules.UnidadMedida.application;

import java.util.List;

import com.farmacia.modules.UnidadMedida.domain.Service.UnidadMedidaService;
import com.farmacia.modules.UnidadMedida.domain.entity.UnidadMedida;

public class FindAllUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidadService;

    public FindAllUnidadMedidaUseCase(UnidadMedidaService unidadMedidadService) {
        this.unidadMedidadService = unidadMedidadService;
    }

    public List<UnidadMedida> execute() {
        return unidadMedidadService.findAllUnidadMedida();
    }
}
