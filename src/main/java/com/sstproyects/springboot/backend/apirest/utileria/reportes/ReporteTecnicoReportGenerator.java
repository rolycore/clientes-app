package com.sstproyects.springboot.backend.apirest.utileria.reportes;
import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.ReporteTecnico;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ReporteTecnicoReportGenerator {
  public static byte[] exportToPdf(List<ReporteTecnico> list) throws JRException, FileNotFoundException {
    return JasperExportManager.exportReportToPdf(getReport(list));
  }

  public static byte[] exportToXls(List<ReporteTecnico> list) throws JRException, FileNotFoundException {
    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
    SimpleOutputStreamExporterOutput output = new SimpleOutputStreamExporterOutput(byteArray);
    JRXlsExporter exporter = new JRXlsExporter();
    exporter.setExporterInput(new SimpleExporterInput(getReport(list)));
    exporter.setExporterOutput(output);
    exporter.exportReport();
    output.close();
    return byteArray.toByteArray();
  }

  private JasperPrint getReport(List<ReporteTecnico> list) throws FileNotFoundException, JRException {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("ReporteTecnicoData", new JRBeanCollectionDataSource(list));

    JasperPrint report = JasperFillManager.fillReport(JasperCompileManager.compileReport(
      ResourceUtils.getFile("classpath:ReporteTecnicoReport.jrxml")
        .getAbsolutePath()), params, new JREmptyDataSource());

    return report;
  }
}
