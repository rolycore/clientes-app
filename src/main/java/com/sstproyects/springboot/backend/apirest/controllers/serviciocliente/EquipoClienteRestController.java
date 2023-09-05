package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;
import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IEquipoClienteDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.EquipoCliente;
import com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas.IEquipoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class EquipoClienteRestController {
  @Autowired
  private IEquipoClienteService equipoClienteService;

  // Buscar todos los equipos de clientes
  @GetMapping("/equipos-clientes")
  public List<EquipoCliente> index() {
    return equipoClienteService.findAll();
  }

  // Buscar equipo de cliente por ID
  @GetMapping("/equipos-clientes/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> show(@PathVariable Long id) {
    EquipoCliente equipoCliente = null;
    Map<String, Object> response = new HashMap<>();
    try {
      equipoCliente = equipoClienteService.findById(id);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la consulta en la base de datos!");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    if (equipoCliente == null) {
      response.put("mensaje", "El equipo de cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<EquipoCliente>(equipoCliente, HttpStatus.OK);
  }

  // Crear equipo de cliente
  @PostMapping("/equipos-clientes")
  public ResponseEntity<?> create(@Valid @RequestBody EquipoCliente equipoCliente, BindingResult result) {
    EquipoCliente equipoClienteNew = null;
    Map<String, Object> response = new HashMap<>();

    if (result.hasErrors()) {
      List<String> errors = result.getFieldErrors()
        .stream()
        .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
        .collect(Collectors.toList());

      response.put("errors", errors);
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }

    try {
      equipoClienteNew = equipoClienteService.save(equipoCliente);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción en la base de datos!");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "El equipo de cliente ha sido creado con éxito!");
    response.put("equipoCliente", equipoClienteNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  // Actualizar equipo de cliente por ID
  @PutMapping("/equipos-clientes/{id}")
  public ResponseEntity<?> update(@Valid @RequestBody EquipoCliente equipoCliente, BindingResult result, @PathVariable Long id) {
    EquipoCliente equipoClienteActual = equipoClienteService.findById(id);
    EquipoCliente equipoClienteUpdated = null;
    Map<String, Object> response = new HashMap<>();

    if (result.hasErrors()) {
      List<String> errors = result.getFieldErrors()
        .stream()
        .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
        .collect(Collectors.toList());

      response.put("errors", errors);
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }

    if (equipoClienteActual == null) {
      response.put("mensaje", "Error: no se pudo editar, el equipo de cliente ID: "
        .concat(id.toString().concat(" no existe en la base de datos!")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }

    try {
      equipoClienteActual.setNombre(equipoCliente.getNombre());
      equipoClienteActual.setCategoria_equipo(equipoCliente.getCategoria_equipo());
      equipoClienteActual.setImagen_equipo(equipoCliente.getImagen_equipo()); // Asegúrate de tener un setter adecuado para la imagen en la clase EquipoCliente
      equipoClienteUpdated = equipoClienteService.save(equipoClienteActual);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al actualizar el equipo de cliente en la base de datos!");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "El equipo de cliente ha sido actualizado con éxito!");
    response.put("equipoCliente", equipoClienteUpdated);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }

  // Borrar equipo de cliente por ID
  @DeleteMapping("/equipos-clientes/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    Map<String, Object> response = new HashMap<>();
    try {
      equipoClienteService.delete(id);
    } catch (DataAccessException e) {
      if (equipoClienteService == null) {
        response.put("mensaje", "Error al eliminar el equipo de cliente de la base de datos!");
        response.put("mensaje", "Error: no se pudo eliminar, el equipo de cliente ID: ".concat(" no existe en la base de datos!"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    response.put("mensaje", "El equipo de cliente ha sido eliminado con éxito!");
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }
}
