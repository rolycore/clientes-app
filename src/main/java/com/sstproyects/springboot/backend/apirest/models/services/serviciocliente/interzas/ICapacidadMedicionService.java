package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.CapacidadMedicion;


import java.util.List;

public interface ICapacidadMedicionService {
  public List<CapacidadMedicion> findAll();
  public CapacidadMedicion findById(Long id);
  public CapacidadMedicion save(CapacidadMedicion capacidadMedicion);
  public void delete(Long id);
}
