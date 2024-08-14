package com.farmacia.modules.Pais.application;

import com.farmacia.modules.Pais.domain.entity.Pais;
import com.farmacia.modules.Pais.domain.service.PaisService;

public class CreatePaisUseCase {
    private PaisService paisService;

    public CreatePaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public void execute(Pais pais ){
        paisService.createPais(pais);
    }
}
