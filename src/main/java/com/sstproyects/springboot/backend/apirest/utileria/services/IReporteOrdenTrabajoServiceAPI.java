package com.sstproyects.springboot.backend.apirest.utileria.services;

import com.sstproyects.springboot.backend.apirest.utileria.reportes.ReporteOrdenTrabajoDTo;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public interface IReporteOrdenTrabajoServiceAPI {
  ReporteOrdenTrabajoDTo obtenerReporteOrdenTrabajo(Map<String, Object> params) throws JRException, IOException, SQLException;
}
