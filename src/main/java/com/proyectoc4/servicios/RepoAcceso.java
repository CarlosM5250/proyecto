package com.proyectoc4.servicios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectoc4.modelo.Usuario;

public interface RepoAcceso extends CrudRepository <Usuario,Integer> {

	@Query(value="SELECT * FROM usuario WHERE Correo=?1 AND Contrasena=?2 ",nativeQuery=true)
	Usuario ValidarAcceso(String Correo,byte[] Contrasena);
}
