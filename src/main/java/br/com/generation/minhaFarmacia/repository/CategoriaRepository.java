package br.com.generation.minhaFarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.generation.minhaFarmacia.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{

	public Categoria findOneByDescricaoContainingIgnoreCase(String descricao);
	
	
}
