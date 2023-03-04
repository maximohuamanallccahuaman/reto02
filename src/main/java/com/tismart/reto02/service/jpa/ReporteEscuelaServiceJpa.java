package com.tismart.reto02.service.jpa;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tismart.reto02.entity.Reporte;
import com.tismart.reto02.service.ReporteEscuelaService;
import com.tismart.reto02.util.TipoReportEnum;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteEscuelaServiceJpa implements ReporteEscuelaService{
	
	@Autowired(required=false)
	private JasperReportManager reportManager;
	
	@Autowired
	private DataSource dataSource;

	@Override
	public Reporte obtenerReporteEscuela(Map<String, Object> params) throws JRException, IOException, SQLException {
		String fileName = "R_Listado_Escuela";
		Reporte dto = new Reporte();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReportEnum.EXCEL.name()) ? ".xlsx"
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
