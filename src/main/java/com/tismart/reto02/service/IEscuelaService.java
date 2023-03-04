package com.tismart.reto02.service;

import java.util.List;

import com.tismart.reto02.entity.Escuela;

public interface IEscuelaService {

	List<Escuela> buscarTodos();
	void guardar(Escuela escuela);
	void eliminar(int IDESCUELA);
	Escuela buscarPorId(Integer IDESCUELA);	
}
