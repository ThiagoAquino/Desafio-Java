package br.com.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.desafio.model.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {
	Usuario findById(Long id);

}
