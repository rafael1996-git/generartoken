package com.ine.cartografia.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;


import com.fasterxml.uuid.Generators;
import com.ine.cartografia.Dao.IUsuario;
import com.ine.cartografia.entity.Autorizacion;
import com.ine.cartografia.entity.ResponseOk;
import com.ine.cartografia.entity.Usuario;
import com.ine.cartografia.service.IServiceDao;





@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class controlador {

	
	@Autowired
	private IServiceDao UserService;


	@Autowired
	private IUsuario Repository;
	
	 @GetMapping(value = "/{correo}")
	public ResponseOk  getCorreo2(@PathVariable  String correo)throws Exception{
		 List<?> usuario= UserService.findByCorreo(correo);
		Usuario user= Repository.findByCorreo(correo);
			ResponseOk reponse = new ResponseOk();

			try {
				 if (usuario != null) {
						if (usuario.isEmpty()) {
							reponse.setEstatus(400);
							reponse.setResultado(null);
							
							reponse.setMsj("Operacion 400:  No se encontro Usuario");
						
						} else{
							UUID token = Generators.randomBasedGenerator().generate();
							LocalDate todaysDate = LocalDate.now();
					        System.out.println(todaysDate);
					        System.out.println("  se ah encontrado usuario con la correo"+correo);
					        
					        				Long idUsuario = user.getId_usuario(); 
					        				String Remesa = UserService.buscarRemesa();
					        				Autorizacion opjs = new Autorizacion();
					        				opjs.setId_usuario(idUsuario);
					        				opjs.setToken(token.toString());
					        				opjs.setEntidad_remesa(Remesa);
					        				opjs.setFecha_hora(todaysDate);
					        				opjs.setId_status(1);
					        
					        				UserService.regisRemesa(opjs);
							reponse.setEstatus(200);
							reponse.setResultado(opjs);
							reponse.setMsj("Operacion Exitosa 200");
						}

					} else {
						System.out.println("ERROR2 no se ah encontrado usuario");
						reponse.setEstatus(500);
						reponse.setMsj(Response.serverError().toString());
					}
				 
				 return reponse;
			} catch (Exception e) {
				throw new ResponseStatusException(
				           HttpStatus.NOT_FOUND, " not found");
			}
		
	
}



}
