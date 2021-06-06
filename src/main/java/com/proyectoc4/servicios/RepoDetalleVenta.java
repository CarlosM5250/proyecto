package com.proyectoc4.servicios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectoc4.modelo.Detalleventa;

public interface RepoDetalleVenta extends CrudRepository<Detalleventa,Integer> {
	
	@Query(value="SELECT * FROM detalleventa WHERE idventa=?1",nativeQuery=true)
	ArrayList<Detalleventa> ListaDetalleVenta(int IdVenta);
}
