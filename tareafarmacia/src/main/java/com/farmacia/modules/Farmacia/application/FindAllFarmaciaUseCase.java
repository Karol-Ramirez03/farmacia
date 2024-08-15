package com.farmacia.modules.Farmacia.application;

import java.util.List;

import com.farmacia.modules.Farmacia.domain.Service.FarmaciaService;
import com.farmacia.modules.Farmacia.domain.entity.Farmacia;

public class FindAllFarmaciaUseCase {
    private FarmaciaService farmaciaService;

    public FindAllFarmaciaUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public List<Farmacia> execute() {
        return farmaciaService.findAllFarmacia();
    }
}
