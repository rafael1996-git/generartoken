package com.ine.cartografia.service;

import java.util.List;

import com.ine.cartografia.entity.Autorizacion;
import com.ine.cartografia.entity.Usuario;


public interface IServiceDao {
	List<Usuario> findByCorreo (String correo);
	public int regisRemesa(Autorizacion remesa);
	public String buscarRemesa();
	
}
