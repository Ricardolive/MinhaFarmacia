package br.com.generation.minhaFarmacia.controller;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import br.com.generation.minhaFarmacia.model.Usuario;
import br.com.generation.minhaFarmacia.repository.UsuarioRepository;
 
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins= "*", allowedHeaders="*")
public class UsuarioController {
  
	@Autowired
	private UsuarioRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAllUsuario(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Usuario> findByIdUsuario(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());	
	}
	
 
	@PutMapping
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	
}
