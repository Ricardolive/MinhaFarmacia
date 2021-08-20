package br.com.generation.minhaFarmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 @Size(min=3,max=100, message="O atributo nome deve conter 3 a 100 caracteres")
 private String nome;
 
 @Size(max=100, message="O atributo descrição deve conter no maximo 100 caracteres")
 private String descricao;
 
 private String imagem;
 
 @Column(columnDefinition = "text")
 private String texto;
 
 @NotNull
 private double preco;
 
 @ManyToOne
 @JsonIgnoreProperties("produto")
 private Fornecedor fornecedor;
 
 @ManyToOne
 @JsonIgnoreProperties("produto")
   private Categoria categoria;
 
 @JsonIgnoreProperties("produto")
 @ManyToMany(mappedBy = "produto", cascade= CascadeType.ALL)
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

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public String getImagem() {
	return imagem;
}

public void setImagem(String imagem) {
	this.imagem = imagem;
}

public String getTexto() {
	return texto;
}

public void setTexto(String texto) {
	this.texto = texto;
}

public double getPreco() {
	return preco;
}

public void setPreco(double preco) {
	this.preco = preco;
}

public Fornecedor getFornecedor() {
	return fornecedor;
}

public void setFornecedor(Fornecedor fornecedor) {
	this.fornecedor = fornecedor;
}

public Categoria getCategoria() {
	return categoria;
}

public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}

public List<Venda> getVenda() {
	return venda;
}

public void setVenda(List<Venda> venda) {
	this.venda = venda;
}
 
 

}