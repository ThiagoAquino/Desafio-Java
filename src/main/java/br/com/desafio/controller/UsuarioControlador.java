package br.com.desafio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.desafio.exception.GeneralException;
import br.com.desafio.model.Telefone;
import br.com.desafio.model.Usuario;
import br.com.desafio.repository.TelefoneRepositorio;
import br.com.desafio.repository.UsuarioRepositorio;

@Controller
public class UsuarioControlador {

	@Autowired
	private UsuarioRepositorio ur;

	@Autowired
	private TelefoneRepositorio tr;

	public UsuarioControlador(){}

	@PostMapping(path="/cadastrar")
	public Usuario salvar(Usuario usuario) {
		//System.out.println(usuario);
		Usuario usuarioNovo = new Usuario("12345678932", "eu", "eu@eu", "1234");
		System.out.println(usuarioNovo);
		System.out.println(usuarioNovo.getId());
		System.out.println(usuarioNovo.getNome());
		System.out.println(usuarioNovo.getEmail());
		ur.save(usuarioNovo);
		return usuarioNovo;
	}

	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Usuario> listar(){
		Iterable<Usuario> usuarios = null;
		System.out.println(usuarios = ur.findAll());
		return usuarios;				
	}


	@GetMapping(path="/listar/{id}")
	public @ResponseBody Usuario buscarUsuario(@PathVariable("id") Long id) throws GeneralException{
		Usuario usuario = ur.findById(id);
		if(usuario != null) {
			return usuario;
		} else {
			throw new GeneralException("Usuario não encontrado");
		}
	}



	@DeleteMapping(path="/deletar/{id}")
	public Usuario remover(@PathVariable("id") Long id) throws GeneralException {
		Usuario usuario = ur.findById(id);
		if(usuario != null) {
			ur.delete(usuario);
			
			return usuario;
		} else {
			throw new GeneralException("Usuario não encontrado");
		}
	}

	@PutMapping(path="/atualizar/{id}")	
	public Usuario atualizar(@PathVariable("id") Long id) throws GeneralException {
		Usuario usuario = ur.findById(id);
		Usuario novoUsuario = new Usuario();
		if(usuario != null) {
			novoUsuario.setEmail(usuario.getEmail());
			novoUsuario.setNome(usuario.getNome());
			novoUsuario.setSenha(usuario.getSenha());
			novoUsuario.setCpf(usuario.getCpf());
			ur.save(novoUsuario);
			return novoUsuario;
		} else {
			throw new GeneralException("Usuario não encontrado");
		}

	}


	public Usuario adicionarTelefone(Long id, Telefone telefone) throws GeneralException {
		Usuario usuario = ur.findById(id);
		if(usuario != null || !telefone.getDdd().isEmpty() || !telefone.getNumero().isEmpty() || !telefone.getTipo().isEmpty()) {
			List<Telefone> telefones = new  ArrayList<Telefone>();
			telefones.add(telefone);
			usuario.setTelefones(telefones); 
			ur.save(usuario);
			return usuario;
		} else {
			throw new GeneralException("Verifique os dados");
		}

	}

	public Usuario removerTelefone(Long id, Telefone telefone) throws GeneralException {
		Usuario usuario = ur.findById(id);
		if(usuario != null || telefone != null) {
			tr.delete(telefone);
			return usuario;
		} else {
			throw new GeneralException("Verifique os dados");
		}
	}



	public <T> int contar (Iterable<T> obj) {
		int valor = 0;
		for(T o : obj) {
			if(o != null) {
				valor++;
			} else {
				valor = 0;
			}
		}
		return valor;
	}
}
