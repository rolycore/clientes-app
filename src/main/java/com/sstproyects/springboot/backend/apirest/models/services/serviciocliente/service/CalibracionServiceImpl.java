package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.service;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.ICalibracionDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Calibracion;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.EquipoCliente;
import com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas.ICalibracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalibracionServiceImpl implements ICalibracionService {
  @Autowired
  private ICalibracionDao iCalibracionDao;


  @Override
  public List<Calibracion> findAll() {

   return (List<Calibracion>) iCalibracionDao.findAll();
  }

  @Override
  public Calibracion findById(Long id) {

    return iCalibracionDao.findById(id).orElse(null);
  }

  @Override
  public Calibracion save(Calibracion calibracion) {
    return iCalibracionDao.save(calibracion);
  }

  @Override
  public void delete(Long id) {
    iCalibracionDao.deleteById(id);
  }
}
