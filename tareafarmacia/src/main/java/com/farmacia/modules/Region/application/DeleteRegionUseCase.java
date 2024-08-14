package com.farmacia.modules.Region.application;

import com.farmacia.modules.Region.domain.Service.RegionService;

public class DeleteRegionUseCase {
    private RegionService regionService;

    public DeleteRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public void execute(String codigoreg){
        regionService.deleteRegion(codigoreg);
    }
}
