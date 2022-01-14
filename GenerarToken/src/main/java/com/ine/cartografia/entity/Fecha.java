package com.ine.cartografia.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "cat_remesa")
public class Fecha implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String remesa;
	@Column(name="año")
	private int año;
	@Column(name="semana")
	private int semana;
	@Column(name="fecha_inicial")
	Date fecha_inicial;
	@Column(name="fecha_final")
	Date fecha_final;
	@Column(name="fecha_corte")
	Date fecha_corte;
	@Column(name="tipo_campaña")
	private int tipo_campaña;
	public String getRemesa() {
		return remesa;
	}
	public void setRemesa(String remesa) {
		this.remesa = remesa;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getSemana() {
		return semana;
	}
	public void setSemana(int semana) {
		this.semana = semana;
	}
	public Date getFecha_inicial() {
		return fecha_inicial;
	}
	public void setFecha_inicial(Date fecha_inicial) {
		this.fecha_inicial = fecha_inicial;
	}
	public Date getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
	public Date getFecha_corte() {
		return fecha_corte;
	}
	public void setFecha_corte(Date fecha_corte) {
		this.fecha_corte = fecha_corte;
	}
	public int getTipo_campaña() {
		return tipo_campaña;
	}
	public void setTipo_campaña(int tipo_campaña) {
		this.tipo_campaña = tipo_campaña;
	}
	public Fecha(String remesa, int año, int semana, Date fecha_inicial, Date fecha_final, Date fecha_corte,
			int tipo_campaña) {
		
		this.remesa = remesa;
		this.año = año;
		this.semana = semana;
		this.fecha_inicial = fecha_inicial;
		this.fecha_final = fecha_final;
		this.fecha_corte = fecha_corte;
		this.tipo_campaña = tipo_campaña;
	}
	public Fecha(){}
	
	

	

}
