package com.sstproyects.springboot.backend.apirest.utileria.controller;

import com.sstproyects.springboot.backend.apirest.utileria.enums.TipoReporteEnum;
import com.sstproyects.springboot.backend.apirest.utileria.reportes.ReporteOrdenTrabajoDTo;
import com.sstproyects.springboot.backend.apirest.utileria.services.IReporteOrdenTrabajoServiceAPI;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class ReporteOrdenTrabajoController {
  @Autowired
  private IReporteOrdenTrabajoServiceAPI iReporteOrdenTrabajoServiceAPI;

  @GetMapping("/ordenes-trabajos/download")
  public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params)
    throws JRException, IOException, SQLException {
    ReporteOrdenTrabajoDTo dTo=iReporteOrdenTrabajoServiceAPI.obtenerReporteOrdenTrabajo(params);

    InputStreamResource streamResource = new InputStreamResource(dTo.getStream());
    MediaType mediaType = null;
    if (TipoReporteEnum.EXCEL.name().equalsIgnoreCase(params.get("tipo").toString())) {
      mediaType = MediaType.APPLICATION_OCTET_STREAM;
    } else {
      mediaType = MediaType.APPLICATION_PDF;
    }

    return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dTo.getFileName() + "\"")
      .contentLength(dTo.getLength()).contentType(mediaType).body(streamResource);

  }
}
