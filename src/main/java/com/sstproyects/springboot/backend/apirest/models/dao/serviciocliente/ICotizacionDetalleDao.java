package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.CotizacionDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICotizacionDetalleDao extends JpaRepository<CotizacionDetalle, Long> {
}
