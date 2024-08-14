package com.farmacia.modules.ModoAdministracion.application;

import java.util.Optional;

import com.farmacia.modules.ModoAdministracion.domain.Service.ModoAdministracionService;
import com.farmacia.modules.ModoAdministracion.domain.entity.ModoAdministracion;

public class FindByIdModoAdministracionUseCase {
    private ModoAdministracionService modoAdministracionService;

    public FindByIdModoAdministracionUseCase(ModoAdministracionService modoAdministracionService) {
        this.modoAdministracionService = modoAdministracionService;
    }
    public Optional<ModoAdministracion> execute(int id) {
        return modoAdministracionService.findById(id);
    }
}
