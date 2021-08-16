package br.com.generation.minhaFarmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name= "tb_fornecedor")
public class Fornecedor {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;


@NotNull
@Size(max= 100, message= "Atributo nome deve conter no máximo 100 caracteres")
private String nome;

@NotNull
@Size(min= 18,max= 18, message= "O atributo cnpj deve conter 18 caracteres")
private String cnpj;

@NotNull
@Size(max= 200, message= "O atributo endereço deve conter no máximo 200 caracteres")
private String endereco;

@NotNull
@Size(min= 9,max= 9, message= "O atributo telefone deve conter no máximo 9 caracteres")
private String telefone;

 

@OneToMany(mappedBy = "fornecedor",cascade= CascadeType.REMOVE)
@JsonIgnoreProperties("fornecedor")
private List<Produto> produto;



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



public String getCnpj() {
	return cnpj;
}



public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
}



public String getEndereco() {
	return endereco;
}



public void setEndereco(String endereco) {
	this.endereco = endereco;
}



public String getTelefone() {
	return telefone;
}



public void setTelefone(String telefone) {
	this.telefone = telefone;
}



public List<Produto> getProduto() {
	return produto;
}



public void setProduto(List<Produto> produto) {
	this.produto = produto;
}


 



}
