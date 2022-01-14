package com.ine.cartografia.entity;

import java.time.LocalDate;



public class Autorizacion {

	
	private Long id_usuario;
	private String token;
	private String entidad_remesa;
	private LocalDate fecha_hora;
	private int id_status;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long idUsuario) {
		this.id_usuario = idUsuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEntidad_remesa() {
		return entidad_remesa;
	}

	public void setEntidad_remesa(String entidad_remesa) {
		this.entidad_remesa = entidad_remesa;
	}

	public LocalDate getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(LocalDate fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
	

	public Autorizacion() {
		
	}

	public Autorizacion(Long id_usuario, String token, String entidad_remesa, LocalDate fecha_hora, int id_status) {
		this.id_usuario = id_usuario;
		this.token = token;
		this.entidad_remesa = entidad_remesa;
		this.fecha_hora = fecha_hora;
		this.id_status = id_status;
	}

	@Override
	public String toString() {
		return "Autorizacion [id_usuario=" + id_usuario + ", token=" + token + ", entidad_remesa=" + entidad_remesa
				+ ", fecha_hora=" + fecha_hora + ", id_status=" + id_status + "]";
	}
	public Autorizacion(String token, String entidad_remesa, LocalDate fecha_hora, int id_status) {
		this.token = token;
		this.entidad_remesa = entidad_remesa;
		this.fecha_hora = fecha_hora;
		this.id_status = id_status;
	}
	

	

}
