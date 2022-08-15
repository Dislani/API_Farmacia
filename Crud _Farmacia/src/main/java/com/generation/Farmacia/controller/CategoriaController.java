package com.generation.Farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.Farmacia.model.CategoriaModel;
import com.generation.Farmacia.repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	@GetMapping ("/nomecategoria/{nome}")
	public ResponseEntity <List<CategoriaModel>> getByNome (@PathVariable String nome){
		return ResponseEntity.ok(categoriaRepository.findAllByCategoriaContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel nomeCategoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoriaRepository.save(nomeCategoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel nomeCategoria){
		return ResponseEntity.ok(categoriaRepository.save(nomeCategoria));
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable Long id) {
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

}
