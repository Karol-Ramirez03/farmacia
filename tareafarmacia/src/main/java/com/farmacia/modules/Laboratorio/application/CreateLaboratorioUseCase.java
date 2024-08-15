package com.farmacia.modules.Laboratorio.application;

import com.farmacia.modules.Laboratorio.domain.Service.LaboratorioService;
import com.farmacia.modules.Laboratorio.domain.entity.Laboratorio;

public class CreateLaboratorioUseCase {
    private LaboratorioService laboratorioService;

    public CreateLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public void execute(Laboratorio laboratorio){
        laboratorioService.createLaboratorio(laboratorio);
    }
}
