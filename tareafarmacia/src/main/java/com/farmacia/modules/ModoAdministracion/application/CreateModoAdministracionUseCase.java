package com.farmacia.modules.ModoAdministracion.application;

import com.farmacia.modules.ModoAdministracion.domain.Service.ModoAdministracionService;
import com.farmacia.modules.ModoAdministracion.domain.entity.ModoAdministracion;

public class CreateModoAdministracionUseCase {
    private ModoAdministracionService modoAdministracionService;

    public CreateModoAdministracionUseCase(ModoAdministracionService modoAdministracionService) {
        this.modoAdministracionService = modoAdministracionService;
    }

    public void execute(ModoAdministracion modoAdministracion) {
        modoAdministracionService.createModoAdministracion(modoAdministracion);
    }
}
