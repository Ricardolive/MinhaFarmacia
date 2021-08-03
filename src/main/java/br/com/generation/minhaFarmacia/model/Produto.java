package br.com.generation.minhaFarmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import br.com.generation.minhaFarmacia.model.Categoria;

@Entity
@Table(name="tb_produto")
public class Produto {

 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private long id;
 
 @NotNull
 @Size(min=3,max=100)
 private String nome;
 
 @Size(max=100)
 private String descricao;
 
 @NotNull
 @Size(min=3,max=100)
 private String fabricante;
 
 @ManyToOne
 @JsonIgnoreProperties("produto")
 @NotNull
   private Categoria categoria;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public String getFabricante() {
	return fabricante;
}

public void setFabricante(String fabricante) {
	this.fabricante = fabricante;
}

public Categoria getCategoria() {
	return categoria;
}

public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}
	
	
	
	
	
	

}
