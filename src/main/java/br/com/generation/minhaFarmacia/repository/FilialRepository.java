package br.com.generation.minhaFarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.minhaFarmacia.model.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {

}
