package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Calibracion;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Cliente;

import java.util.List;

public interface ICalibracionService {
  public List<Calibracion> findAll();
  public Calibracion findById(Long id);
  public Calibracion save(Calibracion calibracion);
  public void delete(Long id);
}
