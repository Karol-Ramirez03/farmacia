package com.farmacia.modules.ModoAdministracion.application;

import java.util.List;

import com.farmacia.modules.ModoAdministracion.domain.Service.ModoAdministracionService;
import com.farmacia.modules.ModoAdministracion.domain.entity.ModoAdministracion;

public class FindAllModoAdministracionUseCase {
    private ModoAdministracionService modoAdministracionService;

    public FindAllModoAdministracionUseCase(ModoAdministracionService modoAdministracionService) {
        this.modoAdministracionService = modoAdministracionService;
    }

    public List<ModoAdministracion> execute(){
        return modoAdministracionService.findAllModoAdministracion();
    }
}
