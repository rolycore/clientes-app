package com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.service;

import com.sstproyects.springboot.backend.apirest.models.dao.serviciocliente.IReporteTecnicoDao;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.ReporteTecnico;
import com.sstproyects.springboot.backend.apirest.models.services.serviciocliente.interzas.IReporteTecnicoService;
import com.sstproyects.springboot.backend.apirest.utileria.reportes.ReporteTecnicoReportGenerator;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
@Service
public class ReporteTecnicoServiceImpl implements IReporteTecnicoService {
  @Autowired
  private IReporteTecnicoDao iReporteTecnicoDao;

  @Autowired
  private ReporteTecnicoReportGenerator reporteTecnicoReportGenerator;

  @Override
  public List<ReporteTecnico> findAll() {
    return iReporteTecnicoDao.findAll();
  }

  @Override
  public ReporteTecnico findById(Long id) {
    return iReporteTecnicoDao.findById(id).get();
  }

  @Override
  public ReporteTecnico save(ReporteTecnico reporteTecnico) {
    return iReporteTecnicoDao.save(reporteTecnico);
  }

  @Override
  public void deleteById(Long id) {
    iReporteTecnicoDao.deleteById(id);
  }

  @Override
  public byte[] exportPdf() throws JRException, FileNotFoundException {
    return ReporteTecnicoReportGenerator.exportToPdf(iReporteTecnicoDao.findAll());
  };


  @Override
  public byte[] exportXls() throws JRException, FileNotFoundException {
    return ReporteTecnicoReportGenerator.exportToXls(iReporteTecnicoDao.findAll());
  }
}
