package com.tismart.reto02.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tismart.reto02.entity.Facultad;
import com.tismart.reto02.repository.FacultadRepository;
import com.tismart.reto02.service.IFacultadService;

@Service
public class FacultadService implements IFacultadService {

	@Autowired
	private FacultadRepository repoFacultad;
	
	@Override
	public List<Facultad> buscarTodos() {
		return repoFacultad.findAll();
	}

	@Override
	public void guardar(Facultad facultad) {
		repoFacultad.save(facultad);
	}

	@Override
	public void eliminar(int IDFACULTAD) {
		repoFacultad.deleteById(IDFACULTAD);
		
	}

	@Override
	public Facultad buscarPorId(Integer IDFACULTAD) {
		Optional<Facultad> optional = repoFacultad.findById(IDFACULTAD);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Facultad> buscarTodas(Pageable page) {
		return repoFacultad.findAll(page);
	}

}
