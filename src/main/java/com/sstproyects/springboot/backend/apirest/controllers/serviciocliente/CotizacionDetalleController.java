package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.ICotizacionDetalleDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.CotizacionDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CotizacionDetalleController {

  private final ICotizacionDetalleDao cotizacionDetalleDao;

  @Autowired
  public CotizacionDetalleController(ICotizacionDetalleDao cotizacionDetalleDao) {
    this.cotizacionDetalleDao = cotizacionDetalleDao;
  }

  @GetMapping("/cotizacionesDetalle")
  public List<CotizacionDetalle> getAllCotizacionesDetalle() {
    return cotizacionDetalleDao.findAll();
  }

  @GetMapping("/cotizacionesDetalle/{id}")
  public ResponseEntity<CotizacionDetalle> getCotizacionDetalleById(@PathVariable Long id) {
    CotizacionDetalle cotizacionDetalle = cotizacionDetalleDao.findById(id).orElse(null);
    if (cotizacionDetalle != null) {
      return ResponseEntity.ok(cotizacionDetalle);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/cotizacionesDetalle")
  public ResponseEntity<CotizacionDetalle> createCotizacionDetalle(@RequestBody CotizacionDetalle cotizacionDetalle) {
    CotizacionDetalle savedCotizacionDetalle = cotizacionDetalleDao.save(cotizacionDetalle);
    return ResponseEntity.ok(savedCotizacionDetalle);
  }

  @PutMapping("/cotizacionesDetalle/{id}")
  public ResponseEntity<CotizacionDetalle> updateCotizacionDetalle(@PathVariable Long id, @RequestBody CotizacionDetalle cotizacionDetalleDetails) {
    CotizacionDetalle cotizacionDetalle = cotizacionDetalleDao.findById(id).orElse(null);
    if (cotizacionDetalle != null) {
      // Actualiza los campos de la entidad con los datos del cotizacionDetalleDetails

      CotizacionDetalle updatedCotizacionDetalle = cotizacionDetalleDao.save(cotizacionDetalle);
      return ResponseEntity.ok(updatedCotizacionDetalle);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/cotizacionesDetalle/{id}")
  public ResponseEntity<Void> deleteCotizacionDetalle(@PathVariable Long id) {
    CotizacionDetalle cotizacionDetalle = cotizacionDetalleDao.findById(id).orElse(null);
    if (cotizacionDetalle != null) {
      cotizacionDetalleDao.delete(cotizacionDetalle);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

