package com.farmacia.modules.ModoAdministracion.application;

import com.farmacia.modules.ModoAdministracion.domain.Service.ModoAdministracionService;

public class DeleteModoAdministracionUseCase {
    private ModoAdministracionService modoAdministracionService;

    public DeleteModoAdministracionUseCase(ModoAdministracionService modoAdministracionService) {
        this.modoAdministracionService = modoAdministracionService;
    }

    public void execute(int idma) {
        modoAdministracionService.deleteModoAdministracion(idma);
    }
}
