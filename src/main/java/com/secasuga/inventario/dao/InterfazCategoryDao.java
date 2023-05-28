package com.secasuga.inventario.dao;
import org.springframework.data.repository.CrudRepository;
import com.secasuga.inventario.model.Categoria;

public interface InterfazCategoryDao extends CrudRepository<Categoria, Long>{

}
