package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Precio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrecioDao extends JpaRepository<Precio, Long> {
}
