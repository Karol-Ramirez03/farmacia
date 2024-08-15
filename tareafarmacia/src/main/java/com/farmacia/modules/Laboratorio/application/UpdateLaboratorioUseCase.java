package com.farmacia.modules.Laboratorio.application;

import com.farmacia.modules.Laboratorio.domain.Service.LaboratorioService;
import com.farmacia.modules.Laboratorio.domain.entity.Laboratorio;

public class UpdateLaboratorioUseCase {
    private LaboratorioService laboratorioService;

    public UpdateLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public void execute(Laboratorio laboratorio){
        laboratorioService.updateLaboratorio(laboratorio);
    }

}
