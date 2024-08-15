package com.farmacia.modules.Cliente.application;

import com.farmacia.modules.Cliente.domain.Service.ClienteService;

public class DeleteClienteUseCase {
    private ClienteService clienteService;

    public DeleteClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(String id) {
        clienteService.deleteCliente(id);
    }
    
}
