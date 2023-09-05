package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;
import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IPrecioDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.Precio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = { "http://localhost:4200" })
public class PrecioController {
  private final IPrecioDao precioDao;

  @Autowired
  public PrecioController(IPrecioDao precioDao) {
    this.precioDao = precioDao;
  }

  @GetMapping("/precios")
  public List<Precio> getAllPrecios() {
    return precioDao.findAll();
  }

  @GetMapping("/precios/{id}")
  public ResponseEntity<Precio> getPrecioById(@PathVariable Long id) {
    Precio precio = precioDao.findById(id).orElse(null);
    if (precio != null) {
      return ResponseEntity.ok(precio);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/precios")
  public ResponseEntity<Precio> createPrecio(@RequestBody Precio precio) {
    Precio savedPrecio = precioDao.save(precio);
    return ResponseEntity.ok(savedPrecio);
  }

  @PutMapping("/precios/{id}")
  public ResponseEntity<Precio> updatePrecio(@PathVariable Long id, @RequestBody Precio precioDetails) {
    Precio precio = precioDao.findById(id).orElse(null);
    if (precio != null) {
      precio.setNombreServicioPrecios(precioDetails.getNombreServicioPrecios());
      precio.setCodServicioPrecios(precioDetails.getCodServicioPrecios());
      precio.setNormaPrecios(precioDetails.getNormaPrecios());
      // Continúa actualizando los otros campos

      Precio updatedPrecio = precioDao.save(precio);
      return ResponseEntity.ok(updatedPrecio);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/precios/{id}")
  public ResponseEntity<Void> deletePrecio(@PathVariable Long id) {
    Precio precio = precioDao.findById(id).orElse(null);
    if (precio != null) {
      precioDao.delete(precio);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
