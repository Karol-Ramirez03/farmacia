package com.farmacia.modules.Pais.application;

import java.util.List;

import com.farmacia.modules.Pais.domain.entity.Pais;
import com.farmacia.modules.Pais.domain.service.PaisService;

public class FindPaisAllUseCase {
    private PaisService paisService;

    public FindPaisAllUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public List<Pais> execute(){
        return paisService.findAllPais();
    }
}
