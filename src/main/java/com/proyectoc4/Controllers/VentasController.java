package com.proyectoc4.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectoc4.modelo.Venta;
import com.proyectoc4.servicios.ServicioVenta;

@Controller
public class VentasController {

	@Autowired
	ServicioVenta servicioventa;
	
	@GetMapping("/Ventas/Ventas")
	public String Misventas(Model modelo,HttpSession sesion) 
	{
		
		Iterable<Venta> ventas=servicioventa.MisVentas();
		
		if(ventas!=null && ventas.iterator().hasNext())
		{
			modelo.addAttribute("ventas", ventas);
		}
		else
		{
			modelo.addAttribute("error", "Aún no hay ventas generadas.");
		}
		
		modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		
		return"Ventas/VerVentas";
	}
}
