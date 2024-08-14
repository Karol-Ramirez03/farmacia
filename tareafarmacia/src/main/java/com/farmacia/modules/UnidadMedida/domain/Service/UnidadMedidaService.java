package com.farmacia.modules.UnidadMedida.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.UnidadMedida.domain.entity.UnidadMedida;

public interface UnidadMedidaService {
public void deleteUnidadMedida(int idum);
    public void updateUnidadMedida(int idum);
    public void createUnidadMedida(UnidadMedida unidadMedida);
    public Optional<UnidadMedida> findById(int idum);
    public List<UnidadMedida> findAllUnidadMedida();
}
