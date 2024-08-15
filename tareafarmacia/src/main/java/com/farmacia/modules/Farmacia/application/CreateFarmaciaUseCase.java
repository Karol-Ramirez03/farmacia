package com.farmacia.modules.Farmacia.application;

import com.farmacia.modules.Farmacia.domain.Service.FarmaciaService;
import com.farmacia.modules.Farmacia.domain.entity.Farmacia;

public class CreateFarmaciaUseCase {
    private FarmaciaService farmaciaService;

    public CreateFarmaciaUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public void execute(Farmacia farmacia) {
        farmaciaService.createFarmacia(farmacia);
    }
}
