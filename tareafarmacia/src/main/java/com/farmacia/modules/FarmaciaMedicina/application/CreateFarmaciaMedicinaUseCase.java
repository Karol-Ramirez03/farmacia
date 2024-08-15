package com.farmacia.modules.FarmaciaMedicina.application;

import com.farmacia.modules.FarmaciaMedicina.domain.Service.FarmaciaMedicinaService;
import com.farmacia.modules.FarmaciaMedicina.domain.entity.FarmaciaMedicina;

public class CreateFarmaciaMedicinaUseCase {
    private FarmaciaMedicinaService farmaciaMedicinaService;

    public CreateFarmaciaMedicinaUseCase(FarmaciaMedicinaService farmaciaMedicinaService) {
        this.farmaciaMedicinaService = farmaciaMedicinaService;
    }

    public void execute(FarmaciaMedicina farmaciaMedicina){
        farmaciaMedicinaService.createFarmaciaMedicina(farmaciaMedicina);
    }
}
