package com.farmacia.modules.Region.application;

import java.util.Optional;

import com.farmacia.modules.Region.domain.Service.RegionService;
import com.farmacia.modules.Region.domain.entity.Region;

public class FindByIdRegionUseCase {
    private RegionService regionService;

    public FindByIdRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public Optional<Region> execute(String codigoreg){
        return regionService.findById(codigoreg);
    }
}
