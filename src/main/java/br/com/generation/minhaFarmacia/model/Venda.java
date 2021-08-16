package br.com.generation.minhaFarmacia.model;

 

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_venda")
public class Venda {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;
	
	
private int numNota;

@Temporal(TemporalType.TIMESTAMP)
private Date dataEmissao = new java.sql.Date(System.currentTimeMillis());
	
	
private double valorTotal;


@ManyToOne
@JsonIgnoreProperties("venda")
private Filial filial;

@ManyToOne
@JsonIgnoreProperties("venda")
private Usuario usuario;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public int getNumNota() {
	return numNota;
}

public void setNumNota(int numNota) {
	this.numNota = numNota;
}

public Date getDataEmissao() {
	return dataEmissao;
}

public void setDataEmissao(Date dataEmissao) {
	this.dataEmissao = dataEmissao;
}

public double getValorTotal() {
	return valorTotal;
}

public void setValorTotal(double valorTotal) {
	this.valorTotal = valorTotal;
}

public Filial getFilial() {
	return filial;
}

public void setFilial(Filial filial) {
	this.filial = filial;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


 
 
	
}
