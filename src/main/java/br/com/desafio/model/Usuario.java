package br.com.desafio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="cpf")
	@NotEmpty
	private String cpf;
	
	@Column(name="nome")
	@NotEmpty
	private String nome;
	
	@Column(name="email")
	@NotEmpty
	private String email;
	
	@Column(name="senha")
	@NotEmpty
	private String senha;
	
	
	@OneToMany
	private List<Telefone> telefones;
	
	
	
	public Usuario(String cpf, String nome, String email, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	

	public Usuario() {}
	
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	
	public boolean equals(Object obj) {
		Usuario usuario = (Usuario) obj;
			if(cpf == usuario.getCpf()) {
				return true;
			} else {
				return false;
			}
	}

}
