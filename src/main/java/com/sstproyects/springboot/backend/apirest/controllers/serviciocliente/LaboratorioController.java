package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;
import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.ILaboratorioDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Laboratorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class LaboratorioController {

  private final ILaboratorioDao laboratorioDao;

  @Autowired
  public LaboratorioController(ILaboratorioDao laboratorioDao) {
    this.laboratorioDao = laboratorioDao;
  }

  @GetMapping("/laboratorios")
  public List<Laboratorio> getAllLaboratorios() {
    return laboratorioDao.findAll();
  }

  @GetMapping("/laboratorios/{id}")
  public ResponseEntity<Laboratorio> getLaboratorioById(@PathVariable Long id) {
    Laboratorio laboratorio = laboratorioDao.findById(id).orElse(null);
    if (laboratorio != null) {
      return ResponseEntity.ok(laboratorio);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/laboratorios")
  public ResponseEntity<Laboratorio> createLaboratorio(@RequestBody Laboratorio laboratorio) {
    Laboratorio savedLaboratorio = laboratorioDao.save(laboratorio);
    return ResponseEntity.ok(savedLaboratorio);
  }

  @PutMapping("/laboratorios/{id}")
  public ResponseEntity<Laboratorio> updateLaboratorio(@PathVariable Long id, @RequestBody Laboratorio laboratorioDetails) {
    Laboratorio laboratorio = laboratorioDao.findById(id).orElse(null);
    if (laboratorio != null) {
      laboratorio.setCodLaboratorios(laboratorioDetails.getCodLaboratorios());
      laboratorio.setDescripcionLaboratorios(laboratorioDetails.getDescripcionLaboratorios());
      // Continúa actualizando los otros campos

      Laboratorio updatedLaboratorio = laboratorioDao.save(laboratorio);
      return ResponseEntity.ok(updatedLaboratorio);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/laboratorios/{id}")
  public ResponseEntity<Void> deleteLaboratorio(@PathVariable Long id) {
    Laboratorio laboratorio = laboratorioDao.findById(id).orElse(null);
    if (laboratorio != null) {
      laboratorioDao.delete(laboratorio);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
