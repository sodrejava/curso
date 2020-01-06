package com.sodre.sodre.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sodre.sodre.domain.Categoria;
import com.sodre.sodre.repositories.CategoriaRepository;
import com.sodre.sodre.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaSvc;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria rs = categoriaSvc.buscarPorId(id);
		return ResponseEntity.ok().body(rs);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void gravar(@RequestBody Categoria categoria) {
		categoriaSvc.gravar(categoria);
	}
	

	//@RequestMapping(method=RequestMethod.GET)
	//public List<Categoria> buscar() {
		//return categoriaSvc.buscar();
	//}
}
