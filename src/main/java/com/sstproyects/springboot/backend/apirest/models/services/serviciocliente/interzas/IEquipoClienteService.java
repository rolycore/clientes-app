package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.EquipoCliente;

import java.util.List;

public interface IEquipoClienteService {
  public List<EquipoCliente> findAll();
  public EquipoCliente findById(Long id);
  public EquipoCliente save(EquipoCliente equipocliente);
  public void delete(Long id);
}
