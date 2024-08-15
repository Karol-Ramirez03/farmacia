package com.farmacia.modules.Medicina.application;

import java.util.Optional;

import com.farmacia.modules.Medicina.domain.Service.MedicinaService;
import com.farmacia.modules.Medicina.domain.entity.Medicina;

public class FindByIdMedicinaUseCase {
    private MedicinaService medicinaService;

    public FindByIdMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public Optional<Medicina> execute(int id){
        return medicinaService.FindByIdMedicina(id);
    }

}
