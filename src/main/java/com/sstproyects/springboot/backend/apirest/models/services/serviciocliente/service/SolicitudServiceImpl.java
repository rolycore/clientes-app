package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.service;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.ISolicitudCabeDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.SolicitudCabe;
import com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SolicitudServiceImpl implements ISolicitudService {
  @Autowired
  private ISolicitudCabeDao solicitudCabeDao;
  @Override
  @Transactional(readOnly = true)
  public List<SolicitudCabe> findAll(Pageable pageable) {
    return (List<SolicitudCabe>) solicitudCabeDao.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public SolicitudCabe findById(Long id) {
    return solicitudCabeDao.findById(id).orElse(null);
  }

  @Override
  public SolicitudCabe save(SolicitudCabe SolicitudCabe) {
    return solicitudCabeDao.save(SolicitudCabe);
  }

  @Override
  public boolean delete(Long id) {
    try {
      solicitudCabeDao.deleteById(id);// Esto eliminará el cliente por ID si existe
      return true; // Devuelve true para indicar éxito
    } catch (Exception e) {
      // En caso de error, puedes registrar el error o realizar otro manejo
      return false; // Devuelve false para indicar que no se pudo eliminar
    }
  }

  @Override
  public SolicitudCabe createOrUpdate(SolicitudCabe solicitudCabe) {
    // Si el Solicitud tiene un ID válido, intenta recuperarlo
    if (solicitudCabe.getIdSolicitud() != null) {
      SolicitudCabe existingSolicitud = solicitudCabeDao.findById(solicitudCabe.getIdSolicitud()).orElse(null);
      if (existingSolicitud != null) {
        // Actualiza los campos relevantes del Solicitud existente si es necesario
        existingSolicitud.setDescripcionSolicitud(solicitudCabe.getDescripcionSolicitud());
        // Actualiza otros campos según tus necesidades
        // ...
        // Guarda el Solicitud actualizado en la base de datos
        return solicitudCabeDao.save(existingSolicitud);
      }
    }

    // Si el Solicitud no tiene un ID válido o no existe, crea uno nuevo
    return solicitudCabeDao.save(solicitudCabe);
  }
}
