package com.farmacia.modules.Cliente.application;

import java.util.Optional;

import com.farmacia.modules.Cliente.domain.Service.ClienteService;
import com.farmacia.modules.Cliente.domain.entity.Cliente;

public class FindByIdClienteUseCase {
    private ClienteService clienteService;

    public FindByIdClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Optional<Cliente> execute(String id) {
        return  clienteService.findById(id);
    }
}
