package com.sstproyects.springboot.backend.apirest.controllers.serviciocliente;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.ReporteTecnico;
import com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas.IReporteTecnicoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1/")
public class ReporteTecnicoController {


  @Autowired
  private IReporteTecnicoService iReporteTecnicoService;

  @GetMapping("/reporte-tecnico")
  public ResponseEntity<?> listAll() {
    return ResponseEntity.ok(iReporteTecnicoService.findAll());
  }

  @GetMapping("/reporte-tecnico/{id}")
  public ResponseEntity<?> listById(@PathVariable Long id) {
    return ResponseEntity.ok(iReporteTecnicoService.findById(id));
  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody ReporteTecnico reporteTecnico) {
    return ResponseEntity.ok(iReporteTecnicoService.save(reporteTecnico));
  }

  @DeleteMapping("/reporte-tecnico/{id}")
  public ResponseEntity<?> deleteById(@PathVariable Long id) {
    iReporteTecnicoService.deleteById(id);
    return ResponseEntity.ok(null);
  }

  @GetMapping("/export-pdf")
  public ResponseEntity<byte[]> exportPdf() throws JRException, FileNotFoundException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    headers.setContentDispositionFormData("petsReport", "petsReport.pdf");
    return ResponseEntity.ok().headers(headers).body(iReporteTecnicoService.exportPdf());
  }

  @GetMapping("/export-xls")
  public ResponseEntity<byte[]> exportXls() throws JRException, FileNotFoundException {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8");
    var contentDisposition = ContentDisposition.builder("attachment")
      .filename("petsReport" + ".xls").build();
    headers.setContentDisposition(contentDisposition);
    return ResponseEntity.ok()
      .headers(headers)
      .body(iReporteTecnicoService.exportXls());
  }
}

