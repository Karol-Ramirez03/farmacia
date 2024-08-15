package com.farmacia.modules.FarmaciaMedicina.application;

import com.farmacia.modules.FarmaciaMedicina.domain.Service.FarmaciaMedicinaService;
import com.farmacia.modules.FarmaciaMedicina.domain.entity.FarmaciaMedicina;

public class UpdateFarmaciaMedicinaUseCase {
    private FarmaciaMedicinaService farmaciaMedicinaService;

    public UpdateFarmaciaMedicinaUseCase(FarmaciaMedicinaService farmaciaMedicinaService) {
        this.farmaciaMedicinaService = farmaciaMedicinaService;
    }
    
    public void execute(FarmaciaMedicina farmaciaMedicina) {
        farmaciaMedicinaService.updateFarmaciaMedicina(farmaciaMedicina);
    }

}
