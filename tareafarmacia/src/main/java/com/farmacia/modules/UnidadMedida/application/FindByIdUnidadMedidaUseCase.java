package com.farmacia.modules.UnidadMedida.application;

import java.util.Optional;

import com.farmacia.modules.UnidadMedida.domain.Service.UnidadMedidaService;
import com.farmacia.modules.UnidadMedida.domain.entity.UnidadMedida;

public class FindByIdUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidadService;

    public FindByIdUnidadMedidaUseCase(UnidadMedidaService unidadMedidadService) {
        this.unidadMedidadService = unidadMedidadService;
    }

    public Optional<UnidadMedida> execute(int idum) {
        return unidadMedidadService.findById(idum);
    }
}
