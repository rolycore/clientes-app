package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IInstrumentosMedicionDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.InstrumentosMedicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = { "http://localhost:4200" })
public class InstrumentoMedicionController {

  private final IInstrumentosMedicionDao instrumentoMedicionDao;

  @Autowired
  public InstrumentoMedicionController(IInstrumentosMedicionDao instrumentoMedicionDao) {
    this.instrumentoMedicionDao = instrumentoMedicionDao;
  }

  @GetMapping("/instrumentos")
  public List<InstrumentosMedicion> getAllInstrumentos() {
    return instrumentoMedicionDao.findAll();
  }

  @GetMapping("/instrumentos/{id}")
  public ResponseEntity<InstrumentosMedicion> getInstrumentoById(@PathVariable Long id) {
    InstrumentosMedicion instrumento = instrumentoMedicionDao.findById(id).orElse(null);
    if (instrumento != null) {
      return ResponseEntity.ok(instrumento);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/instrumentos")
  public ResponseEntity<InstrumentosMedicion> createInstrumento(@RequestBody InstrumentosMedicion instrumento) {
    InstrumentosMedicion savedInstrumento = instrumentoMedicionDao.save(instrumento);
    return ResponseEntity.ok(savedInstrumento);
  }

  @PutMapping("/instrumentos/{id}")
  public ResponseEntity<InstrumentosMedicion> updateInstrumento(@PathVariable Long id, @RequestBody InstrumentosMedicion instrumentoDetails) {
    InstrumentosMedicion instrumento = instrumentoMedicionDao.findById(id).orElse(null);
    if (instrumento != null) {
      instrumento.setNombre(instrumentoDetails.getNombre());
      instrumento.setMide(instrumentoDetails.getMide());
      // Continúa actualizando los otros campos

      InstrumentosMedicion updatedInstrumento = instrumentoMedicionDao.save(instrumento);
      return ResponseEntity.ok(updatedInstrumento);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/instrumentos/{id}")
  public ResponseEntity<Void> deleteInstrumento(@PathVariable Long id) {
    InstrumentosMedicion instrumento = instrumentoMedicionDao.findById(id).orElse(null);
    if (instrumento != null) {
      instrumentoMedicionDao.delete(instrumento);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
