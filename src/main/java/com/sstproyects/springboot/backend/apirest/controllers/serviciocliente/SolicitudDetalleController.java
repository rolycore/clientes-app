package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.ISolicitudDetalleDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.SolicitudDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class SolicitudDetalleController {

  private final ISolicitudDetalleDao solicitudDetalleDao;

  @Autowired
  public SolicitudDetalleController(ISolicitudDetalleDao solicitudDetalleDao) {
    this.solicitudDetalleDao = solicitudDetalleDao;
  }

  @GetMapping("/solicitudesDetalle")
  public List<SolicitudDetalle> getAllSolicitudesDetalle() {
    return solicitudDetalleDao.findAll();
  }

  @GetMapping("/solicitudesDetalle/{id}")
  public ResponseEntity<SolicitudDetalle> getSolicitudDetalleById(@PathVariable Long id) {
    SolicitudDetalle solicitudDetalle = solicitudDetalleDao.findById(id).orElse(null);
    if (solicitudDetalle != null) {
      return ResponseEntity.ok(solicitudDetalle);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/solicitudesDetalle")
  public ResponseEntity<SolicitudDetalle> createSolicitudDetalle(@RequestBody SolicitudDetalle solicitudDetalle) {
    SolicitudDetalle savedSolicitudDetalle = solicitudDetalleDao.save(solicitudDetalle);
    return ResponseEntity.ok(savedSolicitudDetalle);
  }

  @PutMapping("/solicitudesDetalle/{id}")
  public ResponseEntity<SolicitudDetalle> updateSolicitudDetalle(@PathVariable Long id, @RequestBody SolicitudDetalle solicitudDetalleDetails) {
    SolicitudDetalle solicitudDetalle = solicitudDetalleDao.findById(id).orElse(null);
    if (solicitudDetalle != null) {
      // Actualiza los campos de la entidad con los datos del solicitudDetalleDetails

      SolicitudDetalle updatedSolicitudDetalle = solicitudDetalleDao.save(solicitudDetalle);
      return ResponseEntity.ok(updatedSolicitudDetalle);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/solicitudesDetalle/{id}")
  public ResponseEntity<Void> deleteSolicitudDetalle(@PathVariable Long id) {
    SolicitudDetalle solicitudDetalle = solicitudDetalleDao.findById(id).orElse(null);
    if (solicitudDetalle != null) {
      solicitudDetalleDao.delete(solicitudDetalle);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

