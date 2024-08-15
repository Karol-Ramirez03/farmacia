package com.farmacia.modules.Cliente.application;

import com.farmacia.modules.Cliente.domain.Service.ClienteService;
import com.farmacia.modules.Cliente.domain.entity.Cliente;

public class CreateClienteUseCase {
    private ClienteService clienteService;

    public CreateClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    
    public void execute(Cliente cliente) {
        clienteService.createCliente(cliente);
    }

}
