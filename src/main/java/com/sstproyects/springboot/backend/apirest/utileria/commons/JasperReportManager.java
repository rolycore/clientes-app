package com.sstproyects.springboot.backend.apirest.utileria.commons;

import java.io.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.ReporteTecnico;
import com.sstproyects.springboot.backend.apirest.utileria.enums.TipoReporteEnum;
import com.sstproyects.springboot.backend.apirest.utileria.reportes.ReporteTecnicoDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.util.ResourceUtils;

/**
 * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a>
 * @project demo-spring-boot-jasper
 * @class JasperComponent
 * @description
 * @HU_CU_REQ
 * @date 17 sep. 2021
 */
@Component
public class JasperReportManager {

  private static final String REPORT_FOLDER = "reports";

  private static final String JASPER = ".jasper";

  /**
   * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a>
   * @date 17 sep. 2021
   * @description
   * @HU_CU_REQ
   * @param //fileName
   * @param //tipoReporte
   * @param //params
   * @param //ds
   * @return
   * @throws //JRException
   * @throws //IOException
   */
  public ByteArrayOutputStream export(String fileName, String tipoReporte, Map<String, Object> params,
                                      Connection con) throws JRException, IOException {

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    ClassPathResource resource = new ClassPathResource(REPORT_FOLDER + File.separator + fileName + JASPER);

    InputStream inputStream = resource.getInputStream();
    JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, con);
    if (tipoReporte.equalsIgnoreCase(TipoReporteEnum.EXCEL.toString())) {
      JRXlsxExporter exporter = new JRXlsxExporter();
      exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
      exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
      SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
      configuration.setDetectCellType(true);
      configuration.setCollapseRowSpan(true);
      exporter.setConfiguration(configuration);
      exporter.exportReport();
    } else {
      JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
    }

    return stream;
  }

  public static byte[] exportToPdf(List<ReporteTecnicoDTO> list) throws JRException, FileNotFoundException {
    return JasperExportManager.exportReportToPdf(getReport(list));
  }

  public static byte[] exportToXls(List<ReporteTecnicoDTO> list) throws JRException, FileNotFoundException {
    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
    SimpleOutputStreamExporterOutput output = new SimpleOutputStreamExporterOutput(byteArray);
    JRXlsExporter exporter = new JRXlsExporter();
    exporter.setExporterInput(new SimpleExporterInput(getReport(list)));
    exporter.setExporterOutput(output);
    exporter.exportReport();
    output.close();
    return byteArray.toByteArray();
  }

  private static JasperPrint getReport(List<ReporteTecnicoDTO> list) throws FileNotFoundException, JRException {
    Map<String, Object> params = new HashMap<>();
    params.put("reportetecnicoData", new JRBeanCollectionDataSource(list));

    JasperPrint report = JasperFillManager.fillReport(JasperCompileManager.compileReport(
      ResourceUtils.getFile("classpath:reporte_de_tecnico.jrxml")
        .getAbsolutePath()), params, new JREmptyDataSource());

    return report;
  }

}
