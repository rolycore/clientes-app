package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.SolicitudCabe;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ISolicitudService {
  List<SolicitudCabe> findAll(Pageable pageable);

  SolicitudCabe findById(Long id);

  SolicitudCabe save(SolicitudCabe solicitudCabe);
  boolean delete(Long id);

  // Agregamos un método para crear un nuevo SolicitudCabe o actualizar uno existente
  SolicitudCabe createOrUpdate(SolicitudCabe solicitudCabe);
}
