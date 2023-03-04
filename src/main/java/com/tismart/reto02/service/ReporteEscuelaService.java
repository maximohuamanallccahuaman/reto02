package com.tismart.reto02.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.tismart.reto02.entity.Reporte;

import net.sf.jasperreports.engine.JRException;

public interface ReporteEscuelaService {

	Reporte obtenerReporteEscuela(Map<String, Object> params) throws JRException, IOException, SQLException;
}
