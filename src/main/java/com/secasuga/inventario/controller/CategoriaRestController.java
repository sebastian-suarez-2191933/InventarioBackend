package com.secasuga.inventario.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.secasuga.inventario.response.CategoriaResponseRest;
import com.secasuga.inventario.servicios.InterfazCategoriaServicios;

@RestController
@RequestMapping("/api/v1")
public class CategoriaRestController {
	
	@Autowired
	private InterfazCategoriaServicios servicios;

	@GetMapping("/categorias")
	public ResponseEntity<CategoriaResponseRest> searchCategorias(){
	
		ResponseEntity<CategoriaResponseRest> response = servicios.search();
		return response;
	}
	
}
