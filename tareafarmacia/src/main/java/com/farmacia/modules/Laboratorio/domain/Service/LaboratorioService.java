package com.farmacia.modules.Laboratorio.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.Laboratorio.domain.entity.Laboratorio;


public interface LaboratorioService {
    public void deleteLaboratorio(int id);
    public void updateLaboratorio(Laboratorio laboratorio);
    public void createLaboratorio(Laboratorio laboratorio);
    public Optional<Laboratorio> findById(int id);
    public List<Laboratorio> findAllLaboratorio();
}
