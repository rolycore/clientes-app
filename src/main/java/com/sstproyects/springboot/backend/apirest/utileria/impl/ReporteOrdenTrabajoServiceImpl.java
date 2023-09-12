package com.sstproyects.springboot.backend.apirest.utileria.impl;

import com.sstproyects.springboot.backend.apirest.utileria.commons.JasperReportManager;
import com.sstproyects.springboot.backend.apirest.utileria.enums.TipoReporteEnum;
import com.sstproyects.springboot.backend.apirest.utileria.reportes.ReporteOrdenTrabajoDTo;
import com.sstproyects.springboot.backend.apirest.utileria.services.IReporteOrdenTrabajoServiceAPI;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@Service
public class ReporteOrdenTrabajoServiceImpl implements IReporteOrdenTrabajoServiceAPI {
  @Autowired
  private JasperReportManager reportManager;

  @Autowired
  private DataSource dataSource;

  @Override
  public ReporteOrdenTrabajoDTo obtenerReporteOrdenTrabajo(Map<String, Object> params) throws JRException, IOException, SQLException {
    String fileName = "reporte_de_orden_trabajo";
    ReporteOrdenTrabajoDTo dto = new ReporteOrdenTrabajoDTo();
    String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
      : ".pdf";
    dto.setFileName(fileName + extension);

    ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
      dataSource.getConnection());

    byte[] bs = stream.toByteArray();
    dto.setStream(new ByteArrayInputStream(bs));
    dto.setLength(bs.length);

    return dto;
  }
}
