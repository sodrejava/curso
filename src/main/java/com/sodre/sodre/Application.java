package com.sodre.sodre;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sodre.sodre.domain.Categoria;
import com.sodre.sodre.domain.Produto;
import com.sodre.sodre.repositories.CategoriaRepository;
import com.sodre.sodre.repositories.ProdutoRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	

}
