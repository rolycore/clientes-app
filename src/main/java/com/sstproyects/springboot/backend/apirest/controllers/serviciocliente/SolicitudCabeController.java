package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.ISolicitudCabeDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.SolicitudCabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = { "http://localhost:4200" })
public class SolicitudCabeController {

  private final ISolicitudCabeDao solicitudCabeDao;

  @Autowired
  public SolicitudCabeController(ISolicitudCabeDao solicitudCabeDao) {
    this.solicitudCabeDao = solicitudCabeDao;
  }

  @GetMapping("/solicitudesCabe")
  public List<SolicitudCabe> getAllSolicitudesCabe() {
    return solicitudCabeDao.findAll();
  }

  @GetMapping("/solicitudesCabe/{id}")
  public ResponseEntity<SolicitudCabe> getSolicitudCabeById(@PathVariable Long id) {
    SolicitudCabe solicitudCabe = solicitudCabeDao.findById(id).orElse(null);
    if (solicitudCabe != null) {
      return ResponseEntity.ok(solicitudCabe);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/solicitudesCabe")
  public ResponseEntity<SolicitudCabe> createSolicitudCabe(@RequestBody SolicitudCabe solicitudCabe) {
    SolicitudCabe savedSolicitudCabe = solicitudCabeDao.save(solicitudCabe);
    return ResponseEntity.ok(savedSolicitudCabe);
  }

  @PutMapping("/solicitudesCabe/{id}")
  public ResponseEntity<SolicitudCabe> updateSolicitudCabe(@PathVariable Long id, @RequestBody SolicitudCabe solicitudCabeDetails) {
    SolicitudCabe solicitudCabe = solicitudCabeDao.findById(id).orElse(null);
    if (solicitudCabe != null) {
      // Actualiza los campos de la entidad con los datos del solicitudCabeDetails

      SolicitudCabe updatedSolicitudCabe = solicitudCabeDao.save(solicitudCabe);
      return ResponseEntity.ok(updatedSolicitudCabe);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/solicitudesCabe/{id}")
  public ResponseEntity<Void> deleteSolicitudCabe(@PathVariable Long id) {
    SolicitudCabe solicitudCabe = solicitudCabeDao.findById(id).orElse(null);
    if (solicitudCabe != null) {
      solicitudCabeDao.delete(solicitudCabe);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

