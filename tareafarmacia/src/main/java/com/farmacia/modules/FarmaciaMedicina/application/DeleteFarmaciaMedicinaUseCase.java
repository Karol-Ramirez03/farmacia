package com.farmacia.modules.FarmaciaMedicina.application;

import com.farmacia.modules.FarmaciaMedicina.domain.Service.FarmaciaMedicinaService;

public class DeleteFarmaciaMedicinaUseCase {
    private FarmaciaMedicinaService farmaciaMedicinaService;

    public DeleteFarmaciaMedicinaUseCase(FarmaciaMedicinaService farmaciaMedicinaService) {
        this.farmaciaMedicinaService = farmaciaMedicinaService;
    }
    public void execute(int idfarmacia, int idmedicina) {
        farmaciaMedicinaService.deleteFarmaciaMedicina(idfarmacia, idmedicina);
    }

}
