package com.farmacia.modules.Cliente.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.Cliente.domain.entity.Cliente;

public interface ClienteService {
    public void deleteCliente(String id);
    public void updateCliente(Cliente cliente);
    public void createCliente(Cliente cliente);
    public Optional<Cliente> findById(String id);
    public List<Cliente> findAllCliente();
}
