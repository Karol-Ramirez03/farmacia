package com.farmacia.modules.Medicina.application;

import com.farmacia.modules.Medicina.domain.Service.MedicinaService;

public class DeleteMedicinaUseCase {
    private MedicinaService medicinaService;

    public DeleteMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public void execute(int id ){
        medicinaService.DeleteMedicina(id);
    }

}
