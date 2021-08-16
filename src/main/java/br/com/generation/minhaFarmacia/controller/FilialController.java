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
 
import br.com.generation.minhaFarmacia.model.Filial;
import br.com.generation.minhaFarmacia.repository.FilialRepository;

@RestController
@RequestMapping("/filiais")
@CrossOrigin("*")
public class FilialController {
	
	@Autowired
	private FilialRepository repository;
	
	@GetMapping
  	public ResponseEntity<List<Filial>> findAllFilial(){
       return ResponseEntity.ok(repository.findAll());		
  	}
 
 
  	@GetMapping("/id/{id}")
	public ResponseEntity<Filial> findByIdFilial(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
 
	@PostMapping
	public ResponseEntity<Filial> postFilial(@RequestBody Filial filial){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(filial));
	}
	
	@PutMapping
	public ResponseEntity<Filial> putFilial(@RequestBody Filial filial){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(filial));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteFilial(@PathVariable long id){
		repository.deleteById(id);
	}
	
 
}
