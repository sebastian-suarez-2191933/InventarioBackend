package com.secasuga.inventario.servicios;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.secasuga.inventario.dao.InterfazCategoryDao;
import com.secasuga.inventario.model.Categoria;
import com.secasuga.inventario.response.CategoriaResponseRest;

@Service
public class CategoriaServicioImplt implements InterfazCategoriaServicios{

	@Autowired
	private InterfazCategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<CategoriaResponseRest> search() {

		CategoriaResponseRest response= new CategoriaResponseRest();
		
		try {
			List<Categoria> categoria = (List<Categoria>) categoryDao.findAll();
			response.getCategoriaResponse().setCategoria(categoria);
			response.setMetadata("Ok", "00", "Correcto");
			
		} catch (Exception e) {
			response.setMetadata("Erroneo", "-1", "Invalido");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<CategoriaResponseRest> searchById(Long id) {

		CategoriaResponseRest response= new CategoriaResponseRest();
		List<Categoria> 
		lista = new ArrayList<>();
		
		try {
			
			Optional<Categoria> categoria = categoryDao.findById(id);
			if(categoria.isPresent()) {
				
				lista.add(categoria.get());
				response.getCategoriaResponse().setCategoria(lista);
				response.setMetadata("Ok", "00", "Categoria encontrada");
			}	else {
		
				response.setMetadata("Erroneo", "-1", "Categoria inexistente");
				return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND);
			}
			
			
		} catch (Exception e) {
			response.setMetadata("Erroneo", "-1", "Error al consultar por Id");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}


}
