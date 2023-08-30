package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.ICotizacionCabeDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.CotizacionCabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CotizacionCabeController {

  private final ICotizacionCabeDao cotizacionCabeDao;

  @Autowired
  public CotizacionCabeController(ICotizacionCabeDao cotizacionCabeDao) {
    this.cotizacionCabeDao = cotizacionCabeDao;
  }

  @GetMapping("/cotizacionesCabe")
  public List<CotizacionCabe> getAllCotizacionesCabe() {
    return cotizacionCabeDao.findAll();
  }

  @GetMapping("/cotizacionesCabe/{id}")
  public ResponseEntity<CotizacionCabe> getCotizacionCabeById(@PathVariable Long id) {
    CotizacionCabe cotizacionCabe = cotizacionCabeDao.findById(id).orElse(null);
    if (cotizacionCabe != null) {
      return ResponseEntity.ok(cotizacionCabe);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/cotizacionesCabe")
  public ResponseEntity<CotizacionCabe> createCotizacionCabe(@RequestBody CotizacionCabe cotizacionCabe) {
    CotizacionCabe savedCotizacionCabe = cotizacionCabeDao.save(cotizacionCabe);
    return ResponseEntity.ok(savedCotizacionCabe);
  }

  @PutMapping("/cotizacionesCabe/{id}")
  public ResponseEntity<CotizacionCabe> updateCotizacionCabe(@PathVariable Long id, @RequestBody CotizacionCabe cotizacionCabeDetails) {
    CotizacionCabe cotizacionCabe = cotizacionCabeDao.findById(id).orElse(null);
    if (cotizacionCabe != null) {
      // Actualiza los campos de la entidad con los datos del cotizacionCabeDetails

      CotizacionCabe updatedCotizacionCabe = cotizacionCabeDao.save(cotizacionCabe);
      return ResponseEntity.ok(updatedCotizacionCabe);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/cotizacionesCabe/{id}")
  public ResponseEntity<Void> deleteCotizacionCabe(@PathVariable Long id) {
    CotizacionCabe cotizacionCabe = cotizacionCabeDao.findById(id).orElse(null);
    if (cotizacionCabe != null) {
      cotizacionCabeDao.delete(cotizacionCabe);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
