package com.farmacia.modules.Medicina.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.Medicina.domain.entity.Medicina;

public interface MedicinaService {
    public void CreateMedicina(Medicina medicina);
    public void DeleteMedicina(int id);
    public void UpdateMedicina(Medicina medicina);
    public List<Medicina> FindAllMedicina();
    public Optional<Medicina> FindByIdMedicina(int id);

}
