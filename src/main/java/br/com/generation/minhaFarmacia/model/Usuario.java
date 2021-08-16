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
@Table(name= "tb_usuario")
public class Usuario {
	
	
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;
	
@Size(min= 3, max= 100, message= "O atributo nome deve conter 3 a 100 caracteres")
@NotNull
private String nome;

@Size(max= 200, message= "O atributo endereço deve conter no máximo 200 caracteres")
@NotNull
private String endereco;

@Size(min= 10, message= "O atributo email deve conter no minimo 10 caracteres")
private String email;

@Size(max= 14, message= "O atributo telefone deve conter no máximo 14 caracteres")
private String telefone;

@Size(max= 15, message= "O atributo telefone deve conter no máximo 15 caracteres")
private String celular;

@Size(max= 14, message= "O atributo telefone deve conter no máximo 14 caracteres")
private String cpf;

@NotNull
private String senha;

@OneToMany(mappedBy = "usuario", cascade= CascadeType.REMOVE)
@JsonIgnoreProperties("usuario")
private List<Venda> venda;

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

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}

public String getCelular() {
	return celular;
}

public void setCelular(String celular) {
	this.celular = celular;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public List<Venda> getVenda() {
	return venda;
}

public void setVenda(List<Venda> venda) {
	this.venda = venda;
}


 
	

}
