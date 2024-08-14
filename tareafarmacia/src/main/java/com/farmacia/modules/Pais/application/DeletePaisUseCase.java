package com.farmacia.modules.Pais.application;

import com.farmacia.modules.Pais.domain.service.PaisService;

public class DeletePaisUseCase {
    private PaisService paisService;

    public DeletePaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }
    
    public void execute(String codigo){
        paisService.deletepais(codigo);
    }

}
