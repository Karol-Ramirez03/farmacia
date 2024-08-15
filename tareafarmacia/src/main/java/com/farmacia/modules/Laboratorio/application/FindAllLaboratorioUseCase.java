package com.farmacia.modules.Laboratorio.application;

import java.util.List;

import com.farmacia.modules.Laboratorio.domain.Service.LaboratorioService;
import com.farmacia.modules.Laboratorio.domain.entity.Laboratorio;

public class FindAllLaboratorioUseCase {
    private LaboratorioService laboratorioService;

    public FindAllLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public List<Laboratorio> execute(){
        return laboratorioService.findAllLaboratorio();
    } 

    
}
