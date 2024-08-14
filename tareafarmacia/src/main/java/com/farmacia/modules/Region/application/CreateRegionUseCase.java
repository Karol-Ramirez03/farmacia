package com.farmacia.modules.Region.application;

import com.farmacia.modules.Region.domain.Service.RegionService;
import com.farmacia.modules.Region.domain.entity.Region;

public class CreateRegionUseCase {
    private RegionService regionService;

    public CreateRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public void execute(Region region){
        regionService.createRegion(region);
    }

    
}
