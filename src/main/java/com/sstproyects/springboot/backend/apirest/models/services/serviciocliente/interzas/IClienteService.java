package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Cliente;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.EquipoCliente;

import java.util.List;

public interface IClienteService {
  public List<Cliente> findAll();
  public Cliente findById(Long id);
  public Cliente save(Cliente cliente);
  public void delete(Long id);
}
