package br.com.desafio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="TELEFONE")
public class Telefone implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cod")
	private Long cod;
	
	@Column(name="ddd")
	@NotEmpty
	private String ddd;
	
	@Column(name="numero")
	@NotEmpty
	private String numero;
	
	@Column(name="tipo")
	@NotEmpty
	private String tipo;
	
	//@ManyToOne
	//private Usuario usuario;
	
	public Telefone(String ddd, String numero, String tipo) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}
	
	public Telefone(){}


	public Long getCod() {
		return cod;
	}

	
	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/*
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	*/
	
}
