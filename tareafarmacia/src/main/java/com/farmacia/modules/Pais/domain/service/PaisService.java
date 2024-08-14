package com.farmacia.modules.Pais.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.Pais.domain.entity.Pais;

public interface PaisService {
    public void deletepais(String codigo);
    public void updatePais(String codigo);
    public void createPais(Pais pais);
    public Optional<Pais> findById(String codigo);
    public List<Pais> findAllPais();
}
