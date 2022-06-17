package com.ine.cartografia.Dao;

import org.springframework.data.repository.CrudRepository;

import com.ine.cartografia.entity.Usuario;


public interface IUsuario extends  CrudRepository<Usuario, Long>{
	Usuario findByCorreo (String correo);
}
