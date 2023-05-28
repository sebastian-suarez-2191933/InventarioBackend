package com.secasuga.inventario.response;
import java.util.List;
import com.secasuga.inventario.model.Categoria;

public class CategoriaResponse {

	private List<Categoria> categoria;

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
}
