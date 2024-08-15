package com.farmacia.modules.Farmacia.application;

import java.util.Optional;

import com.farmacia.modules.Farmacia.domain.Service.FarmaciaService;
import com.farmacia.modules.Farmacia.domain.entity.Farmacia;

public class FindByIdFarmaciaUseCase {
    private FarmaciaService farmaciaService;

    public FindByIdFarmaciaUseCase(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    public Optional<Farmacia> execute(int idf){
        return farmaciaService.findById(idf);
    }
}