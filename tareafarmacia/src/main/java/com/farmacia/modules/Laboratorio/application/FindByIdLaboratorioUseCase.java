package com.farmacia.modules.Laboratorio.application;

import java.util.Optional;

import com.farmacia.modules.Laboratorio.domain.Service.LaboratorioService;
import com.farmacia.modules.Laboratorio.domain.entity.Laboratorio;

public class FindByIdLaboratorioUseCase {
    private LaboratorioService laboratorioService;

    public FindByIdLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public Optional<Laboratorio> execute(int id){
        return laboratorioService.findById(id);
    }

    
}
