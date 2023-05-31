package com.secasuga.inventario.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.secasuga.inventario.response.CategoriaResponseRest;
import com.secasuga.inventario.servicios.InterfazCategoriaServicios;

@RestController
@RequestMapping("/api/v1")
public class CategoriaRestController {
	
	@Autowired
	private InterfazCategoriaServicios servicios;

	/**
	 * get all categories
	 * @return
	 */
	@GetMapping("/categorias")
	public ResponseEntity<CategoriaResponseRest> searchCategorias(){
	
		ResponseEntity<CategoriaResponseRest> response = servicios.search();
		return response;
	}
	/**
	 * get all categories by id
	 * @param id
	 * @return
	 */
	@GetMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponseRest> searchCategoriasById(@PathVariable Long id){
	
		ResponseEntity<CategoriaResponseRest> response = servicios.searchById(id);
		return response;
	}
	
}
