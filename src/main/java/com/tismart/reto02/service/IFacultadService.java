package com.tismart.reto02.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tismart.reto02.entity.Facultad;

public interface IFacultadService {
	
	List<Facultad> buscarTodos();
	void guardar(Facultad facultad);
	void eliminar(int IDFACULTAD);
	Facultad buscarPorId(Integer IDFACULTAD);
	Page<Facultad> buscarTodas(Pageable page);	

}
