package com.farmacia.modules.Region.application;

import java.util.List;

import com.farmacia.modules.Region.domain.Service.RegionService;
import com.farmacia.modules.Region.domain.entity.Region;

public class FindAllRegionUseCase {
    private RegionService regionService;

    public FindAllRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public List<Region> execute(){
        return regionService.findAllRegion();
    }
}
