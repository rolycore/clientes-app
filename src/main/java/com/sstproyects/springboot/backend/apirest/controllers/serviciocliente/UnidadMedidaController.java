package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IUnidadMedidaDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.UnidadMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class UnidadMedidaController {

  private final IUnidadMedidaDao unidadMedidaDao;

  @Autowired
  public UnidadMedidaController(IUnidadMedidaDao unidadMedidaDao) {
    this.unidadMedidaDao = unidadMedidaDao;
  }

  @GetMapping("/unidadesMedida")
  public List<UnidadMedida> getAllUnidadesMedida() {
    return unidadMedidaDao.findAll();
  }

  @GetMapping("/unidadesMedida/{id}")
  public ResponseEntity<UnidadMedida> getUnidadMedidaById(@PathVariable Long id) {
    UnidadMedida unidadMedida = unidadMedidaDao.findById(id).orElse(null);
    if (unidadMedida != null) {
      return ResponseEntity.ok(unidadMedida);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/unidadesMedida")
  public ResponseEntity<UnidadMedida> createUnidadMedida(@RequestBody UnidadMedida unidadMedida) {
    UnidadMedida savedUnidadMedida = unidadMedidaDao.save(unidadMedida);
    return ResponseEntity.ok(savedUnidadMedida);
  }

  @PutMapping("/unidadesMedida/{id}")
  public ResponseEntity<UnidadMedida> updateUnidadMedida(@PathVariable Long id, @RequestBody UnidadMedida unidadMedidaDetails) {
    UnidadMedida unidadMedida = unidadMedidaDao.findById(id).orElse(null);
    if (unidadMedida != null) {
      unidadMedida.setAbreviaturaUm(unidadMedidaDetails.getAbreviaturaUm());
      unidadMedida.setDescripcionUm(unidadMedidaDetails.getDescripcionUm());
      unidadMedida.setEstadoUm(unidadMedidaDetails.getEstadoUm());
      unidadMedida.setObservacionesUm(unidadMedidaDetails.getObservacionesUm());

      UnidadMedida updatedUnidadMedida = unidadMedidaDao.save(unidadMedida);
      return ResponseEntity.ok(updatedUnidadMedida);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/unidadesMedida/{id}")
  public ResponseEntity<Void> deleteUnidadMedida(@PathVariable Long id) {
    UnidadMedida unidadMedida = unidadMedidaDao.findById(id).orElse(null);
    if (unidadMedida != null) {
      unidadMedidaDao.delete(unidadMedida);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

