package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IServicioDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class ServicioController {
  @Autowired
  private IServicioDao iServicioDao;



  @Autowired
  public ServicioController(IServicioDao iServicioDao) {
    this.iServicioDao= iServicioDao;
  }

  @GetMapping("/servicios")
  public List<Servicio> getAllServicios() {
    return iServicioDao.findAll();
  }

  @GetMapping("/servicios/{id}")
  public ResponseEntity<Servicio> getServicioById(@PathVariable Long id) {
    Servicio servicio = iServicioDao.findById(id).orElse(null);
    if (servicio != null) {
      return ResponseEntity.ok(servicio);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/servicios")
  public ResponseEntity<Servicio> createServicio(@RequestBody Servicio servicio) {
    Servicio savedServicio = iServicioDao.save(servicio);
    return ResponseEntity.ok(savedServicio);
  }

  @PutMapping("/servicios/{id}")
  public ResponseEntity<Servicio> updateServicio(@PathVariable Long id, @RequestBody Servicio servicioDetails) {
    Servicio servicio = iServicioDao.findById(id).orElse(null);
    if (servicio != null) {
      servicio.setNombreServicio(servicioDetails.getNombreServicio());
      servicio.setDescripcionServicio(servicioDetails.getDescripcionServicio());
      servicio.setPrecioServicio(servicioDetails.getPrecioServicio());
      // Continúa actualizando los otros campos

      Servicio updatedServicio = iServicioDao.save(servicio);
      return ResponseEntity.ok(updatedServicio);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/servicios/{id}")
  public ResponseEntity<Void> deleteServicio(@PathVariable Long id) {
    Servicio servicio = iServicioDao.findById(id).orElse(null);
    if (servicio != null) {
      iServicioDao.delete(servicio);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
