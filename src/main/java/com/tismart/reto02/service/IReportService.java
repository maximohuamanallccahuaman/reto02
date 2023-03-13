package com.tismart.reto02.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.tismart.reto02.entity.ReportDTO;

import net.sf.jasperreports.engine.JRException;

public interface IReportService {
	
	ReportDTO getReport(Map<String, Object> params, String reportName) throws JRException, IOException, SQLException;

}
