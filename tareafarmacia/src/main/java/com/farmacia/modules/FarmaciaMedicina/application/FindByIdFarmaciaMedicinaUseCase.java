package com.farmacia.modules.FarmaciaMedicina.application;

import java.util.Optional;

import com.farmacia.modules.FarmaciaMedicina.domain.Service.FarmaciaMedicinaService;
import com.farmacia.modules.FarmaciaMedicina.domain.entity.FarmaciaMedicina;

public class FindByIdFarmaciaMedicinaUseCase {
    private FarmaciaMedicinaService farmaciaMedicinaService;

    public FindByIdFarmaciaMedicinaUseCase(FarmaciaMedicinaService farmaciaMedicinaService) {
        this.farmaciaMedicinaService = farmaciaMedicinaService;
    }
    
    public Optional<FarmaciaMedicina> execute(int idfarmacia, int idmedicina) {
        return farmaciaMedicinaService.findById(idfarmacia, idmedicina);
    }
}
