package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.SolicitudCabe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitudCabeDao extends JpaRepository<SolicitudCabe, Long> {
}
