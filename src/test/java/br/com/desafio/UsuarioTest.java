package br.com.desafio;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.desafio.controller.UsuarioControlador;
import br.com.desafio.exception.GeneralException;
import br.com.desafio.model.Usuario;

class UsuarioTest {
	UsuarioControlador uc = new UsuarioControlador();

	@Test
	void cadastrar() {

		Usuario usuarioTest1 = new Usuario("12345678901","usuario1", "customer1@gmail.com","1234");

		Usuario user = uc.salvar(usuarioTest1);
		boolean b = false;
		if(user != null) {
			b = true;
		}
		assertTrue(b);




	}
	@Test
	void listar() {

		Iterable<Usuario> user = uc.listar();
		boolean b = false;

		if(user != null) {
			b = true;
		}
		assertTrue(b);
	}

	
	@Test
	void buscarUsuario() {
		long id = (long) 1;
		Usuario user = null;
		try {
			user = uc.buscarUsuario(id);
			boolean b = false;
			
			if(user != null) {
				b = true;
			}
			assertTrue(b);
		} catch (GeneralException e) {
			e.printStackTrace();
		}
	}
	
}