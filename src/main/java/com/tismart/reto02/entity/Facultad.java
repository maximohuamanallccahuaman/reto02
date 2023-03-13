package com.tismart.reto02.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="FACULTAD")
public class Facultad {
	
	@Id
	@Column(name="IDFACULTAD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DESCFACULTAD")
	private String descripcion;
	
	@Column(name="FECHAREGISTRO")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Facultad [id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}
}
