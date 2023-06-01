package com.secasuga.inventario.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secasuga.inventario.model.Categoria;
import com.secasuga.inventario.response.CategoriaResponseRest;
import com.secasuga.inventario.servicios.InterfazCategoriaServicios;

@CrossOrigin(origins = {"http://localhost:4200"})
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
	
	/**
	 * save categories
	 * @param Categoria
	 * @return
	 */
	@PostMapping("/categorias")
	public ResponseEntity<CategoriaResponseRest> saveCategorias(@RequestBody Categoria categoria){
	
		ResponseEntity<CategoriaResponseRest> response = servicios.save(categoria);
		return response;
	}
	
	/**
	 * Update category by id
	 * @param categoria
	 * @param id
	 * @return
	 */
	@PutMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponseRest> actualizarCategorias(@RequestBody Categoria categoria, @PathVariable Long id){
	
		ResponseEntity<CategoriaResponseRest> response = servicios.reSave(categoria, id);
		return response;
	}
	
	/**
	 * Delete category
	 * @param id
	 * @return
	 */
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponseRest> delete(@PathVariable Long id){
	
		ResponseEntity<CategoriaResponseRest> response = servicios.deleteById(id);
		return response;
	}
}
