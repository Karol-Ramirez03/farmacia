package com.farmacia.modules.ModoAdministracion.application;

import com.farmacia.modules.ModoAdministracion.domain.Service.ModoAdministracionService;

public class UpdateModoAdministracionUseCase {
    private ModoAdministracionService modoAdministracionService;

    public UpdateModoAdministracionUseCase(ModoAdministracionService modoAdministracionService) {
        this.modoAdministracionService = modoAdministracionService;
    }

    public void execute(int idma){
        modoAdministracionService.updateModoAdministracion(idma);
    }
}
