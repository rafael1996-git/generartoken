package com.ine.cartografia.entity;

import java.io.Serializable;
/**
 * Esta clase es DTO ResponseOk, para setter con la respuesta de web service
 * @author Alejandro Sandoval Rodriguez 
 * @version 1.3.1
 * 
 */




public class ResponseOk implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param estatus
	 * @param resultado
	 * @param msj
	 * 
	 */
	private Integer estatus;
	private Autorizacion resultado;
	private String msj;

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Autorizacion getResultado() {
		return resultado;
	}

	public void setResultado(Autorizacion opjs) {
		this.resultado = opjs;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

}
