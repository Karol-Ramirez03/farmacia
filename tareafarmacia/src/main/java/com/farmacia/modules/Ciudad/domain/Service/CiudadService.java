package com.farmacia.modules.Ciudad.domain.Service;

import java.util.List;
import java.util.Optional;

import com.farmacia.modules.Ciudad.domain.entity.Ciudad;


public interface CiudadService  {
    public void deleteCiudad(String codigociudad);
    public void updateCiudad(Ciudad ciudad);
    public void createCiudad(Ciudad ciudad);
    public Optional<Ciudad> findById(String codigociudad);
    public List<Ciudad> findAllCiudad();
}
