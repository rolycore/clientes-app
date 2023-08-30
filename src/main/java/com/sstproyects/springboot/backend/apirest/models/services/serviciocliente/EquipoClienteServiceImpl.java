package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente;
import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IEquipoClienteDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.EquipoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EquipoClienteServiceImpl implements IEquipoClienteService {
  @Autowired
  private IEquipoClienteDao equipoclienteDao;
  @Override
  @Transactional(readOnly = true)
  public List<EquipoCliente> findAll() {
    return (List<EquipoCliente>) equipoclienteDao.findAll();
  }

  @Override
  @Transactional
  public EquipoCliente findById(Long id) {
    return equipoclienteDao.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public EquipoCliente save(EquipoCliente equipocliente) {
    return equipoclienteDao.save(equipocliente);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    equipoclienteDao.deleteById(id);
  }
}
