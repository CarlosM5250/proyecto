package com.proyectoc4.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoc4.modelo.Categoria;

@Service
public class ServicioCategoria {

	@Autowired
	RepoCategoria repoCategoria;
	
	
	private String Mensaje;
	
	public String getMensaje(){
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje=mensaje;
	}
	
	public boolean Agregar(Categoria categoria) 
	{
		try 
		{
			repoCategoria.save(categoria);
			
			this.Mensaje="Registrado Correctamente.";
			return true;
			
		} catch (Exception e)
		{
			// TODO: handle exception
			this.Mensaje="Error al registrar la categira"+e;
			
			return false;
		}
	}
	
	public boolean Eliminar(int IdCategoria)
	{
		try 
		{
			repoCategoria.deleteById(IdCategoria);
			
			this.Mensaje="Eliminado Correctamente.";
			return true;
			
		} catch (Exception e)
		{
			// TODO: handle exception
			this.Mensaje="Error al eliminar al eliminar la categoria.";
			
			return false;
		}
	}
	
	public Iterable<Categoria> Vercategoria()
	{
		try 
		{
			this.Mensaje="";
			
			return repoCategoria.findAll();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			this.Mensaje=e.getMessage();
			
			return null;
		}
	}
	
	public Categoria Buscarategoria(int id) {
		try 
		{
			Categoria categoria=repoCategoria.findById(id).get();
			
			return categoria==null ? new Categoria():categoria;
		} catch (Exception e) {
			// TODO: handle exception
			this.Mensaje="No se pudo reslizar la búsqueda del rol para el usuario"+e.getMessage();
			
			return null;
		}
	}
}
