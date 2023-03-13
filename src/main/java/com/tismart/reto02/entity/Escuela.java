package com.tismart.reto02.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ESCUELA")
public class Escuela {
	
	@Id
	@Column(name="IDESCUELA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDFACULTAD")
	private Facultad facultad;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="CANTALUMNOS")
	private Integer cantidadAlumnos;
	
	@Column(name="RECURSOFISCAL")
	private Double recursoFiscal;
	
	@Column(name="LICENCIADA")
	private String licenciada;
	
	@Column(name="CLASIFICACION")
	private Integer clasificacion;
	
	@Column(name="FECHAREGISTRO")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidadAlumnos() {
		return cantidadAlumnos;
	}
	public void setCantidadAlumnos(Integer cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}
	public Double getRecursoFiscal() {
		return recursoFiscal;
	}
	public void setRecursoFiscal(Double recursoFiscal) {
		this.recursoFiscal = recursoFiscal;
	}
	public String getLicenciada() {
		return licenciada;
	}
	public void setLicenciada(String licenciada) {
		this.licenciada = licenciada;
	}
	public Integer getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(Integer clasificacion) {
		this.clasificacion = clasificacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Escuela [id=" + id + ", facultad=" + facultad + ", nombre=" + nombre + ", cantidadAlumnos="
				+ cantidadAlumnos + ", recursoFiscal=" + recursoFiscal + ", licenciada=" + licenciada
				+ ", clasificacion=" + clasificacion + ", fecha=" + fecha + "]";
	}

}
