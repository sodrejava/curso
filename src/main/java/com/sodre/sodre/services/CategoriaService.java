package com.sodre.sodre.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sodre.sodre.domain.Categoria;
import com.sodre.sodre.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);
		return categoria.orElse(null);
	}
	
	public List<Categoria> buscar() {
		return repo.findAll();
	}
	
	public Categoria gravar(Categoria categoria) {
		return repo.save(categoria);
	}
}
