package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.InstrumentosMedicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInstrumentosMedicionDao extends JpaRepository<InstrumentosMedicion, Long> {
}
