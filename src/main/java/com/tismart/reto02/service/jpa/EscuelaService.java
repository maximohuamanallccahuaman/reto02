package com.tismart.reto02.service.jpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.tismart.reto02.entity.Escuela;
import com.tismart.reto02.repository.EscuelaRepository;
import com.tismart.reto02.service.IEscuelaService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EscuelaService implements IEscuelaService {

	@Autowired
	private EscuelaRepository repoEscuela;
	
	@Override
	public List<Escuela> buscarTodos() {
		return repoEscuela.findAll();
	}

	@Override
	public void guardar(Escuela escuela) {
		repoEscuela.save(escuela);

	}

	@Override
	public void eliminar(int IDESCUELA) {
		repoEscuela.deleteById(IDESCUELA);

	}

	@Override
	public Escuela buscarPorId(Integer IDESCUELA) {
		Optional<Escuela> optional = repoEscuela.findById(IDESCUELA);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		String path = "/reto02/src/main/resources/static/pdfs";
		List<Escuela> escuela = repoEscuela.findAll();
		File file = ResourceUtils.getFile("classpath:reporte_escuela.jrxml");
		JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(escuela);

		Map<String, Object> parameters = new HashMap<>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"/escuela.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path+"/escuela.pdf");
		}
		return "reporte generado en el path :" + path;

	}

}
