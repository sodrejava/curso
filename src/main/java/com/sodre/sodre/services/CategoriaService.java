package com.sodre.sodre.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sodre.sodre.domain.Categoria;
import com.sodre.sodre.repositories.CategoriaRepository;
import com.sodre.sodre.services.exceptions.ObjectNotFountException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);
		
		categoria.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()
		));
		
		return categoria.orElse(null);
	}
	
	public List<Categoria> buscar() {
		return repo.findAll();
	}
	
	public Categoria gravar(Categoria categoria) {
		return repo.save(categoria);
	}
	
	public void deletar(Integer id) {
		repo.deleteById(id);
	}
}
