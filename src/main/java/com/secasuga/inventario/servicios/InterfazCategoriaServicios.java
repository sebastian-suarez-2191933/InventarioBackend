package com.secasuga.inventario.servicios;
import org.springframework.http.ResponseEntity;
import com.secasuga.inventario.response.CategoriaResponseRest;

public interface InterfazCategoriaServicios {
	
	public ResponseEntity<CategoriaResponseRest> search();
	public ResponseEntity<CategoriaResponseRest> searchById(Long id);

}
