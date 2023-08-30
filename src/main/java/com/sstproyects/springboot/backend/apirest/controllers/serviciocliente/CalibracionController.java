package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.ICalibracionDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Calibracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CalibracionController {

  private final ICalibracionDao calibracionDao;

  @Autowired
  public CalibracionController(ICalibracionDao calibracionDao) {
    this.calibracionDao = calibracionDao;
  }

  @GetMapping("/calibraciones")
  public List<Calibracion> getAllCalibraciones() {
    return calibracionDao.findAll();
  }

  @GetMapping("/calibraciones/{id}")
  public ResponseEntity<Calibracion> getCalibracionById(@PathVariable Long id) {
    Calibracion calibracion = calibracionDao.findById(id).orElse(null);
    if (calibracion != null) {
      return ResponseEntity.ok(calibracion);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/calibraciones")
  public ResponseEntity<Calibracion> createCalibracion(@RequestBody Calibracion calibracion) {
    Calibracion savedCalibracion = calibracionDao.save(calibracion);
    return ResponseEntity.ok(savedCalibracion);
  }

  @PutMapping("/calibraciones/{id}")
  public ResponseEntity<Calibracion> updateCalibracion(@PathVariable Long id, @RequestBody Calibracion calibracionDetails) {
    Calibracion calibracion = calibracionDao.findById(id).orElse(null);
    if (calibracion != null) {
      calibracion.setDescripcion(calibracionDetails.getDescripcion());
      calibracion.setCertificado(calibracionDetails.getCertificado());
      // Continúa actualizando los otros campos

      Calibracion updatedCalibracion = calibracionDao.save(calibracion);
      return ResponseEntity.ok(updatedCalibracion);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/calibraciones/{id}")
  public ResponseEntity<Void> deleteCalibracion(@PathVariable Long id) {
    Calibracion calibracion = calibracionDao.findById(id).orElse(null);
    if (calibracion != null) {
      calibracionDao.delete(calibracion);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
