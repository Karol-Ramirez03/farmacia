package com.farmacia.modules.Medicina.application;

import com.farmacia.modules.Medicina.domain.Service.MedicinaService;
import com.farmacia.modules.Medicina.domain.entity.Medicina;

public class CreateMedicinaUseCase {
    private MedicinaService medicinaService;

    public CreateMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public void execute(Medicina medicina ){
        medicinaService.CreateMedicina(medicina);
    }
    
}
