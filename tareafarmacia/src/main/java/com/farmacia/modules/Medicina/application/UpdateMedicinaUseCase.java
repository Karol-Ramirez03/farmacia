package com.farmacia.modules.Medicina.application;

import com.farmacia.modules.Medicina.domain.Service.MedicinaService;
import com.farmacia.modules.Medicina.domain.entity.Medicina;

public class UpdateMedicinaUseCase {
    private MedicinaService medicinaService;

    public UpdateMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public void execute(Medicina medicina){
        medicinaService.UpdateMedicina(medicina);
    }

}
