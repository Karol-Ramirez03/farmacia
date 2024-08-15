package com.farmacia.modules.Farmacia.application;

import com.farmacia.modules.Farmacia.domain.Service.FarmaciaService;

public class DeleteFarmaciaUseCase {
    private FarmaciaService farmaciaService;

    public DeleteFarmaciaUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public void execute(int idf){
        farmaciaService.deleteFarmacia(idf);
    }
}
