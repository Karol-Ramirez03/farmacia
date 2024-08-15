package com.farmacia.modules.Laboratorio.application;

import com.farmacia.modules.Laboratorio.domain.Service.LaboratorioService;

public class DeleteLaboratorioUseCase {
    private LaboratorioService laboratorioService;

    public DeleteLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public void execute(int id){
        laboratorioService.deleteLaboratorio(id);
    }
    
}
