package com.farmacia.modules.Region.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.Region.domain.entity.Region;

public interface RegionService {
    public void deleteRegion(String codigoReg);
    public void updateRegion(Region region);
    public void createRegion(Region region);
    public Optional<Region> findById(String codigoReg);
    public List<Region> findAllRegion();
}
