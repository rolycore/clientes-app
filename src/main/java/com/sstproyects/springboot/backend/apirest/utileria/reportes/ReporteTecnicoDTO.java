package com.sstproyects.springboot.backend.apirest.utileria.reportes;

import com.sstproyects.springboot.backend.apirest.models.entity.serviciocliente.ReporteTecnico;

import java.io.ByteArrayInputStream;
import java.util.List;

public class ReporteTecnicoDTO {

  private String fileName;
  private ByteArrayInputStream stream;
  private int length;

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public ByteArrayInputStream getStream() {
    return stream;
  }

  public void setStream(ByteArrayInputStream stream) {
    this.stream = stream;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }
}
