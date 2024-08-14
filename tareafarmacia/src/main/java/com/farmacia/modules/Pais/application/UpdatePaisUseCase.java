package com.farmacia.modules.Pais.application;

import com.farmacia.modules.Pais.domain.service.PaisService;

public class UpdatePaisUseCase {
    private PaisService paisService;

    public UpdatePaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public void execute(String codigo){
        paisService.updatePais(codigo);
    }

    
}
