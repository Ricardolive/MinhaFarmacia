package br.com.generation.minhaFarmacia.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.generation.minhaFarmacia.model.Usuario;
import br.com.generation.minhaFarmacia.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
    private UsuarioRepository  repository;

    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
         Optional<Usuario> user = repository.findByCpf(username);
         user.orElseThrow(() -> new UsernameNotFoundException( username + " not found."));
                    return user.map(UserDetailsImpl::new).get();

    }
}



	

 
