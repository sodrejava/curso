package com.sodre.sodre.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sodre.sodre.domain.Categoria;
import com.sodre.sodre.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaSvc;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> find() {
		return ResponseEntity.ok().body(categoriaSvc.buscar());
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria rs = categoriaSvc.buscarPorId(id);
		System.out.print(rs);
		return ResponseEntity.ok().body(rs);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Categoria gravar(@RequestBody Categoria categoria) {
		return categoriaSvc.gravar(categoria);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public Integer deletar(@PathVariable Integer id) {
		categoriaSvc.deletar(id);
		return id;
	}
	

	//@RequestMapping(method=RequestMethod.GET)
	//public List<Categoria> buscar() {
		//return categoriaSvc.buscar();
	//}
}
