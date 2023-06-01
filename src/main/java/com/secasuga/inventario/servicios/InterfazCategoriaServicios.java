package com.secasuga.inventario.servicios;
import org.springframework.http.ResponseEntity;
import com.secasuga.inventario.model.Categoria;
import com.secasuga.inventario.response.CategoriaResponseRest;

public interface InterfazCategoriaServicios {
	
	public ResponseEntity<CategoriaResponseRest> search();
	public ResponseEntity<CategoriaResponseRest> searchById(Long id);
	public ResponseEntity<CategoriaResponseRest> save(Categoria categoria);
	public ResponseEntity<CategoriaResponseRest> reSave(Categoria categoria, Long id);
	public ResponseEntity<CategoriaResponseRest> deleteById(Long id);
}
