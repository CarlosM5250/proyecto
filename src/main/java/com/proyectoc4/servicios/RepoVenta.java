package com.proyectoc4.servicios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectoc4.modelo.Venta;

public interface RepoVenta extends CrudRepository<Venta,Integer> {
	
	@Query(value="SELECT MAX(idventa) AS idventa FROM venta",nativeQuery=true)
	int UltimoRegistroVenta();
	
	
    @Query(value="SELECT * FROM venta WHERE idusuario=?1",nativeQuery=true)
	ArrayList<Venta> ListaVentasComprasIdUsuario(int IdUsuario);
}
