package br.com.generation.minhaFarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.minhaFarmacia.model.Produto;

@Repository		
public interface ProdutoRepository extends JpaRepository<Produto,Long>{

	public Produto findOneByDescricaoContainingIgnoreCase(String descricao);
}
