package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente;

import java.util.List;


import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Cliente;


public interface IClienteService {


	public List<Cliente> findAll();
	public Cliente findById(Long id);
	public Cliente save(Cliente cliente);
	public void delete(Long id);

}
