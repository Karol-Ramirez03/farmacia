package com.farmacia.modules.Medicina.application;

import java.util.List;

import com.farmacia.modules.Medicina.domain.Service.MedicinaService;
import com.farmacia.modules.Medicina.domain.entity.Medicina;

public class FindAllMedicinaUseCase {
    private MedicinaService medicinaService;

    public FindAllMedicinaUseCase(MedicinaService medicinaService) {
        this.medicinaService = medicinaService;
    }

    public List<Medicina> execute() {
        return medicinaService.FindAllMedicina();
    }
}
