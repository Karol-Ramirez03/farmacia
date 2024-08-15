package com.farmacia.modules.FarmaciaMedicina.application;

import java.util.List;

import com.farmacia.modules.FarmaciaMedicina.domain.Service.FarmaciaMedicinaService;
import com.farmacia.modules.FarmaciaMedicina.domain.entity.FarmaciaMedicina;

public class FindAllFarmaciaMedicinaUseCase {
    private FarmaciaMedicinaService farmaciaMedicinaService;

    public FindAllFarmaciaMedicinaUseCase(FarmaciaMedicinaService farmaciaMedicinaService) {
        this.farmaciaMedicinaService = farmaciaMedicinaService;
    }

    public List<FarmaciaMedicina> execute(){
        return farmaciaMedicinaService.findAllFarmaciaMedicina();
    }
}
