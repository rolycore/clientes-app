package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.ISolicitudCabeDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Cliente;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.SolicitudCabe;
import com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = { "http://localhost:4200" })
public class SolicitudCabeController {


  @Autowired
  private ISolicitudService iSolicitudService;




  @GetMapping("/solicitudesCabe")
  public ResponseEntity<Page<SolicitudCabe>>listarSolicitudesCabe(Pageable pageable) {
    return ResponseEntity.ok((Page<SolicitudCabe>) iSolicitudService.findAll(pageable));
  }

  @GetMapping("/solicitudesCabe/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<SolicitudCabe> getSolicitudCabeById(@Valid @PathVariable Long id) {
    SolicitudCabe solicitudCabe = iSolicitudService.findById(id);
    if (solicitudCabe != null) {
      return ResponseEntity.ok(solicitudCabe);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/solicitudesCabe")
  public ResponseEntity<?> create(@Valid @RequestBody SolicitudCabe solicitudCabe, BindingResult result) {
   SolicitudCabe solicitudnueva=null;
    if (result.hasErrors()) {
      return ResponseEntity.badRequest().body(result.getAllErrors());
    }
    solicitudnueva = iSolicitudService.save(solicitudCabe);
    URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(solicitudnueva.getIdSolicitud()).toUri();
    return ResponseEntity.created(ubicacion).body(solicitudnueva);
  }
  // Actualizar Solicitud por ID
  @PutMapping("/solicitudesCabe/{id}")
  public ResponseEntity<?> update(@Valid @RequestBody SolicitudCabe solicitudCabe, BindingResult result) {
    if (result.hasErrors()) {
      return ResponseEntity.badRequest().body(result.getAllErrors());
    }
    SolicitudCabe solicitudUpdated = iSolicitudService.createOrUpdate(solicitudCabe);

    if (solicitudUpdated == null) {
      // Actualiza los campos de la entidad con los datos del solicitudCabeDetails
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(solicitudUpdated);
  }
  // Borrar Solicitud por ID
  @DeleteMapping("/solicitudesCabe/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    SolicitudCabe solicitudCabe = iSolicitudService.findById(id);
    if (solicitudCabe != null) {
      iSolicitudService.delete(id);
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok().build();
    }
  }
}

