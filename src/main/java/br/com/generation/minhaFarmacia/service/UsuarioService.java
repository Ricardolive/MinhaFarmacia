package br.com.generation.minhaFarmacia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;

import br.com.generation.minhaFarmacia.model.UserLogin;
import br.com.generation.minhaFarmacia.model.Usuario;
import br.com.generation.minhaFarmacia.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
    private UsuarioRepository repository;

    public Usuario CadastrarUsuario(Usuario usuario){
       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

      String senhaEncoder = encoder.encode(usuario.getSenha());
      usuario.setSenha(senhaEncoder);
          	return repository.save(usuario);
  }

     
  public Optional<UserLogin> Logar(Optional<UserLogin> user){
      BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
      Optional<Usuario> usuario = repository.findByCpf(user.get().getCpf());

       if(usuario.isPresent()){
         if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())){
              String auth = user.get().getCpf() + ":" + user.get().getSenha();
  	byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
               String authHeader = "Basic " + new String(encodedAuth);

             user.get().setToken(authHeader);
             user.get().setId(usuario.get().getId());
             user.get().setNome(usuario.get().getNome());
             user.get().setTipo(usuario.get().getTipo());

             return user;
        }
      }     
       	return null;
  } 

}
 
