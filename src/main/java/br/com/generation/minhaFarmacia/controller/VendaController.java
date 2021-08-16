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

import br.com.generation.minhaFarmacia.model.Venda;
import br.com.generation.minhaFarmacia.repository.VendaRepository;
 

 
 
@RestController
@RequestMapping("/vendas")
@CrossOrigin("*")
public class VendaController {
	
	@Autowired
	private VendaRepository repository;
	
	@GetMapping
  	public ResponseEntity<List<Venda>> findAllVenda(){
       return ResponseEntity.ok(repository.findAll());		
  	}
 
 
  	@GetMapping("/id/{id}")
	public ResponseEntity<Venda> findByIdVenda(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
 
	@PostMapping
	public ResponseEntity<Venda> postVenda(@RequestBody Venda venda){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(venda));
	}
	
	@PutMapping
	public ResponseEntity<Venda> putVenda(@RequestBody Venda venda){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(venda));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteVenda(@PathVariable long id){
		repository.deleteById(id);
	}
		
 

}
