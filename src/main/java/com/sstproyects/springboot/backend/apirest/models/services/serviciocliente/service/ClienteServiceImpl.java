package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.service;

import java.util.List;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.EquipoCliente;
import com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IClienteDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
  @Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {

      return (List<Cliente>) clienteDao.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Cliente findById(Long id) {
    // TODO Auto-generated method stub
    return clienteDao.findById(id).orElse(null);
  }

  @Override
  public Cliente save(Cliente cliente) {
    return clienteDao.save(cliente);
  }


  @Override
  public void delete(Long id) {

  }
}
