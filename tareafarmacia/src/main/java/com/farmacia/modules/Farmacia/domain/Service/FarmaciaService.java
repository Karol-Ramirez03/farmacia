package com.farmacia.modules.Farmacia.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.Farmacia.domain.entity.Farmacia;

public interface FarmaciaService {
    public void deleteFarmacia(int id);
    public void updateFarmacia(Farmacia farmacia);
    public void createFarmacia(Farmacia farmacia);
    public Optional<Farmacia> findById(int id);
    public List<Farmacia> findAllFarmacia();
}
