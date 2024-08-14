package com.farmacia.modules.PrincipioActivo.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.PrincipioActivo.domain.entity.PrincipioActivo;

public interface PrincipioActivoService {
    public void deletePrincipioActivo(int idpa);
    public void updatePrincipioActivo(int idpa);
    public void createPrincipioActivo(PrincipioActivo principioActivo);
    public Optional<PrincipioActivo> findById(int idpa);
    public List<PrincipioActivo> findAllPrincipioActivo();
}
