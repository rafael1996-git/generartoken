package com.ine.cartografia.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;


import com.ine.cartografia.entity.Autorizacion;
import com.ine.cartografia.entity.Control;
import com.ine.cartografia.entity.Usuario;

@Repository
public class ServiceImpl implements IServiceDao{

	
	@Autowired
    private JdbcTemplate jdbcTemplate;


	@Override
	  public List<Usuario> findByCorreo(String user) {
		 Pattern p = Pattern.compile("[\\s]");
		 Matcher m = p.matcher(user);
	        String result = m.replaceAll("");
		 System.out.println(user);
			System.out.println(result);
	    String q = "SELECT TRIM(correo) from usuario WHERE TRIM(correo) ILIKE '%"+result+"%'";

	    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Usuario.class));
	  }

	@Override
	public int regisRemesa(Autorizacion remesa) {
		String sql = "INSERT INTO public.autorizacion (id_usuario,token,entidad_remesa,fecha_hora,id_status) VALUES (?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { remesa.getId_usuario(), remesa.getToken(),
				remesa.getEntidad_remesa(), remesa.getFecha_hora(), remesa.getId_status() });
	}

	@Override
	public String buscarRemesa() {
		String sql = "SELECT remesa FROM public.cat_remesa WHERE now()::date between fecha_inicial and fecha_final ";
		return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				return rs.next() ? rs.getString("remesa") : null;
			}
		});
	}

	@Override
	public String buscarEntidad() {
		String sql = "SELECT entidad FROM public.entidad WHERE activa=0 ";
		return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {
			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				return rs.next() ? rs.getString("entidad") : null;
			}
		});

	}

	@Override
	public int register(Control inserta) {
		String sql = "INSERT INTO public.control (entidad,remesa,fecha_hora,id_usuario,id_operacion,id_status) VALUES (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { inserta.getEntidad(), inserta.getRemesa(),
				inserta.getFecha_hora(), inserta.getId_usuario(), inserta.getId_operacion(), inserta.getId_status() });

	}

	

	


}
