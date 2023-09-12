package com.sstproyects.springboot.backend.apirest.utileria.services;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.ReporteTecnico;
import com.sstproyects.springboot.backend.apirest.utileria.reportes.ReporteTecnicoDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IReporteTecnicoServiceAPI {
 //List<ReporteTecnicoDTO> findAll();
  ReporteTecnicoDTO obtenerReporteTecnico(Map<String, Object> params) throws JRException, IOException, SQLException;
  // byte[] exportPdf() throws JRException, FileNotFoundException;
  //byte[] exportXls() throws JRException, FileNotFoundException;
}
