package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.SolicitudDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitudDetalleDao extends JpaRepository<SolicitudDetalle, Long> {
}
