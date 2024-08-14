package com.farmacia.modules.ModoAdministracion.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.ModoAdministracion.domain.entity.ModoAdministracion;

public interface ModoAdministracionService {
    public void deleteModoAdministracion(int idma);
    public void updateModoAdministracion(int idma);
    public void createModoAdministracion(ModoAdministracion ModoAdministracion);
    public Optional<ModoAdministracion> findById(int idma);
    public List<ModoAdministracion> findAllModoAdministracion();
}
