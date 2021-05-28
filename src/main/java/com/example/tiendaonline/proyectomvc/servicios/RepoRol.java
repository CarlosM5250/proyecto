package com.example.tiendaonline.proyectomvc.servicios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.tiendaonline.proyectomvc.modelo.Rol;


public interface RepoRol extends CrudRepository <Rol,Integer> {

	@Query(value="SELECT * FROM rol WHERE idrol = ?1", nativeQuery=true)
	Rol BuscarRol(int IdRol);
}
