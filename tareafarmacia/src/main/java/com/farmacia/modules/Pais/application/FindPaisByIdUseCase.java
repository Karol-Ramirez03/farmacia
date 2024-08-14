package com.farmacia.modules.Pais.application;

import java.util.Optional;

import com.farmacia.modules.Pais.domain.entity.Pais;
import com.farmacia.modules.Pais.domain.service.PaisService;

public class FindPaisByIdUseCase {
    private PaisService paisService;

    public FindPaisByIdUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public Optional<Pais> execute(String codigo){
        return paisService.findById(codigo);
    }
    
}
