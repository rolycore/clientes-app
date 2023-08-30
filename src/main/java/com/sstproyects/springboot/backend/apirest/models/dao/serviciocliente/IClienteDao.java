package com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {


}
