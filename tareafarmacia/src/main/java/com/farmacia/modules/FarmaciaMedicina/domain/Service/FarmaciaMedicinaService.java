package com.farmacia.modules.FarmaciaMedicina.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.FarmaciaMedicina.domain.entity.FarmaciaMedicina;

public interface FarmaciaMedicinaService {
    public void deleteFarmaciaMedicina(int idfarmacia, int idmedicina);
    public void updateFarmaciaMedicina(FarmaciaMedicina FarmaciaMedicina);
    public void createFarmaciaMedicina(FarmaciaMedicina FarmaciaMedicina);
    public Optional<FarmaciaMedicina> findById(int idfarmacia, int idmedicina);
    public List<FarmaciaMedicina> findAllFarmaciaMedicina();
}
