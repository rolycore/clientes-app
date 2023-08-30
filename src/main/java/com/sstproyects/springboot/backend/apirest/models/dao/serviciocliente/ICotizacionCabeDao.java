package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.CotizacionCabe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICotizacionCabeDao extends JpaRepository<CotizacionCabe, Long> {
}
