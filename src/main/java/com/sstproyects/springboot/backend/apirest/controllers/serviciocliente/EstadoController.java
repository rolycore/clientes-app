package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IEstadoDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class EstadoController {

  private final IEstadoDao IEstadoDao;

  @Autowired
  public EstadoController(IEstadoDao IEstadoDao) {
    this.IEstadoDao = IEstadoDao;
  }

  @GetMapping("/estados")
  public List<Estado> getAllEstados() {
    return IEstadoDao.findAll();
  }

  @GetMapping("/estados/{id}")
  public ResponseEntity<Estado> getEstadoById(@PathVariable Integer id) {
    Estado estado = IEstadoDao.findById(id).orElse(null);
    if (estado != null) {
      return ResponseEntity.ok(estado);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/estados")
  public ResponseEntity<Estado> createEstado(@RequestBody Estado estado) {
    Estado savedEstado = IEstadoDao.save(estado);
    return ResponseEntity.ok(savedEstado);
  }

  @PutMapping("/estados/{id}")
  public ResponseEntity<Estado> updateEstado(@PathVariable Integer id, @RequestBody Estado estadoDetails) {
    Estado estado = IEstadoDao.findById(id).orElse(null);
    if (estado != null) {
      estado.setDescripcionEstado(estadoDetails.getDescripcionEstado());
      estado.setCodEstado(estadoDetails.getCodEstado());
      estado.setObservacionesEstados(estadoDetails.getObservacionesEstados());

      Estado updatedEstado = IEstadoDao.save(estado);
      return ResponseEntity.ok(updatedEstado);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/estados/{id}")
  public ResponseEntity<Void> deleteEstado(@PathVariable Integer id) {
    Estado estado = IEstadoDao.findById(id).orElse(null);
    if (estado != null) {
      IEstadoDao.delete(estado);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
