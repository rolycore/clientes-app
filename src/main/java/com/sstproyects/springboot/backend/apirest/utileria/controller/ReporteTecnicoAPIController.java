package com.sstproyects.springboot.backend.apirest.utileria.controller;

import com.sstproyects.springboot.backend.apirest.utileria.enums.TipoReporteEnum;
import com.sstproyects.springboot.backend.apirest.utileria.reportes.ReporteOrdenTrabajoDTo;
import com.sstproyects.springboot.backend.apirest.utileria.reportes.ReporteTecnicoDTO;
import com.sstproyects.springboot.backend.apirest.utileria.services.IReporteTecnicoServiceAPI;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
@PreAuthorize("hasRole('ADMIN')")
public class ReporteTecnicoAPIController {
  @Autowired
  private IReporteTecnicoServiceAPI iReporteTecnicoServiceAPI;

  @GetMapping("/reporte-tecnico/download")
  public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params) {
    try {
      ReporteTecnicoDTO dTo = iReporteTecnicoServiceAPI.obtenerReporteTecnico(params);

      // Verificar si el InputStream es nulo
      if (dTo.getStream() == null) {
        throw new NullPointerException("El InputStream es nulo.");
      }

      InputStreamResource streamResource = new InputStreamResource(dTo.getStream());
      MediaType mediaType = null;

      if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
        mediaType = MediaType.APPLICATION_OCTET_STREAM;
      } else {
        mediaType = MediaType.APPLICATION_PDF;
      }

      return ResponseEntity.ok()
        .header("Content-Disposition", "inline; filename=\"" + dTo.getFileName() + "\"")
        .contentLength(dTo.getLength())
        .contentType(mediaType)
        .body(streamResource);
    } catch (NullPointerException e) {
      // Manejo de la excepción NullPointerException
      System.err.println("Se ha producido una NullPointerException: " + e.getMessage());
      e.printStackTrace(); // Opcional: Imprimir el rastreo de la pila
      // Enviar una respuesta personalizada para la excepción NullPointerException
      Map<String, Object> response = new HashMap<>();
      response.put("mensaje", "Error de NullPointerException.");
      response.put("error", e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Resource) response);
    } catch (JRException ex) {
      // Manejo de excepción JRException
      System.err.println("Se produjo un error en la generación de reporte: " + ex.getMessage());
      ex.printStackTrace(); // Opcional: Imprimir el rastreo de la pila
      // Realiza alguna otra acción de manejo de excepciones específica para JRException
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } catch (IOException ex) {
      // Manejo de excepción IOException
      System.err.println("Se produjo un error de E/S: " + ex.getMessage());
      ex.printStackTrace(); // Opcional: Imprimir el rastreo de la pila
      // Realiza alguna otra acción de manejo de excepciones específica para IOException
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } catch (SQLException ex) {
      // Manejo de excepción SQLException
      System.err.println("Se produjo un error de base de datos: " + ex.getMessage());
      ex.printStackTrace(); // Opcional: Imprimir el rastreo de la pila
      // Realiza alguna otra acción de manejo de excepciones específica para SQLException
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } catch (DataAccessException ex) {
      // Manejo de excepción DataAccessException
      System.err.println("Error al realizar la inserción en la base de datos: " + ex.getMessage());
      ex.printStackTrace(); // Opcional: Imprimir el rastreo de la pila
      // Enviar una respuesta personalizada para la excepción DataAccessException
      Map<String, Object> response = new HashMap<>();
      response.put("mensaje", "Error al realizar la inserción en la base de datos.");
      response.put("error", ex.getMessage() + ": " + ex.getMostSpecificCause().getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Resource) response);
    }
  }
  /*@GetMapping("/export-pdf")
  public ResponseEntity<byte[]> exportPdf() throws JRException, FileNotFoundException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    headers.setContentDispositionFormData("reporte_de_tecnico", "reporte_de_tecnico.pdf");
    return ResponseEntity.ok().headers(headers).body(iReporteTecnicoServiceAPI.exportPdf());
  }*/

 /* @GetMapping("/reporte-tecnico/download")
  public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params)
    throws JRException, IOException, SQLException {
    ReporteTecnicoDTO dTo = iReporteTecnicoServiceAPI.obtenerReporteTecnico(params);

    InputStreamResource streamResource = new InputStreamResource(dTo.getStream());
    MediaType mediaType = null;
    if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) || mediaType != null) {
      mediaType = MediaType.APPLICATION_OCTET_STREAM;
    } else {
      mediaType = MediaType.APPLICATION_PDF;
    }

    return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dTo.getFileName() + "\"")
      .contentLength(dTo.getLength()).contentType(mediaType).body(streamResource);

  }*/
}
