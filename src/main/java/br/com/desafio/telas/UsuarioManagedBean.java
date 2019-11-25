package br.com.desafio.telas;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.desafio.model.*;
import br.com.desafio.controller.*;

@ManagedBean(name="UsuarioMB")
public class UsuarioManagedBean {

	private Usuario usuario = new Usuario();

	private UsuarioControlador uc = new UsuarioControlador();

	public String cadastraUsuario() {


		Usuario validacao = uc.salvar(usuario); 
		if (validacao != null) {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Sucesso!", "Usuário cadastrado com sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", 
							"Erro no cadastr de usuário!"));

		}

		return "";
	}

	public List<Usuario> getUsuarios() throws SQLException {
		List<Usuario> listaUsuarios = (List<Usuario>) uc.listar();
		return listaUsuarios;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}