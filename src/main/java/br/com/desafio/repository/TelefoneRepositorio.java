package br.com.desafio.repository;

import br.com.desafio.model.Telefone;
import org.springframework.data.repository.CrudRepository;


public interface TelefoneRepositorio extends CrudRepository<Telefone, String> {
	Telefone findByCod(Telefone telefone);
	
}
