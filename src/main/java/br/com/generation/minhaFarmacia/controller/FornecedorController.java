package br.com.generation.minhaFarmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.minhaFarmacia.model.Fornecedor;
import br.com.generation.minhaFarmacia.repository.FornecedorRepository;

@RestController
@RequestMapping("/fornecedores")
@CrossOrigin("*")
public class FornecedorController {

	
	@Autowired
	private FornecedorRepository repository;
	
	@GetMapping
  	public ResponseEntity<List<Fornecedor>> findAllFornecedor(){
       return ResponseEntity.ok(repository.findAll());		
  	}
 
 
  	@GetMapping("/id/{id}")
	public ResponseEntity<Fornecedor> findByIdFornecedor(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
 
	@PostMapping
	public ResponseEntity<Fornecedor> postFornecedor(@RequestBody Fornecedor fornecedor){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(fornecedor));
	}
	
	@PutMapping
	public ResponseEntity<Fornecedor> putFornecedor(@RequestBody Fornecedor fornecedor){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(fornecedor));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteFornecedor(@PathVariable long id){
		repository.deleteById(id);
	}
	
	
	
	
}
