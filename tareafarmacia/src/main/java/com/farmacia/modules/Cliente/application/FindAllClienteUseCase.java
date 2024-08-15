package com.farmacia.modules.Cliente.application;

import java.util.List;

import com.farmacia.modules.Cliente.domain.Service.ClienteService;
import com.farmacia.modules.Cliente.domain.entity.Cliente;

public class FindAllClienteUseCase {
    private ClienteService clienteService;

    public FindAllClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public  List<Cliente> execute(){
        return clienteService.findAllCliente();
    }
}
