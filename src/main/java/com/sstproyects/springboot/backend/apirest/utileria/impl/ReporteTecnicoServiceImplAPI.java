package com.sstproyects.springboot.backend.apirest.utileria.impl;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IReporteTecnicoDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.ReporteTecnico;
import com.sstproyects.springboot.backend.apirest.utileria.commons.JasperReportManager;
import com.sstproyects.springboot.backend.apirest.utileria.enums.TipoReporteEnum;
import com.sstproyects.springboot.backend.apirest.utileria.reportes.ReporteTecnicoDTO;
import com.sstproyects.springboot.backend.apirest.utileria.services.IReporteTecnicoServiceAPI;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReporteTecnicoServiceImplAPI implements IReporteTecnicoServiceAPI {
  @Autowired
  private JasperReportManager reportManager;
  @Autowired
  private DataSource dataSource;





  @Override
  public ReporteTecnicoDTO obtenerReporteTecnico(Map<String, Object> params) throws JRException, IOException, SQLException {

    String fileName = "reporte_de_tecnico";
    ReporteTecnicoDTO dto = new ReporteTecnicoDTO();

    try {
      String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
      dto.setFileName(fileName + extension);

      ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(),
        params, dataSource.getConnection());

      byte[] bs = stream.toByteArray();
      dto.setStream(new ByteArrayInputStream(bs));
      dto.setLength(bs.length);
    } catch (NullPointerException e) {
      // Manejar la excepción NullPointerException aquí
      // Puedes registrar un mensaje de error o realizar otras acciones según tus necesidades.
      e.printStackTrace(); // Esto imprimirá la traza de la excepción en la consola.
    }

    return dto;
  /*  String fileName = "reporte_de_tecnico";
    ReporteTecnicoDTO dto = new ReporteTecnicoDTO();
    String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
      : ".pdf";
    dto.setFileName(fileName + extension);

    ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
      dataSource.getConnection());

    byte[] bs = stream.toByteArray();
    dto.setStream(new ByteArrayInputStream(bs));
    dto.setLength(bs.length);

    return dto;*/
  }
/*
  @Override
  public byte[] exportPdf() throws JRException, FileNotFoundException {
    return JasperReportManager.exportToPdf(iReporteTecnicoServiceAPI.findAll());
  }

  @Override
  public byte[] exportXls() throws JRException, FileNotFoundException {
    return JasperReportManager.exportToXls(iReporteTecnicoServiceAPI.findAll());
  }*/
}

