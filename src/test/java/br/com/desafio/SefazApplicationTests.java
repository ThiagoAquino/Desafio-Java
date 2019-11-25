package br.com.desafio;

import java.util.ArrayList;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import br.com.desafio.controller.UsuarioControlador;
import br.com.desafio.exception.GeneralException;
import br.com.desafio.model.Telefone;
import br.com.desafio.model.Usuario;

@SpringBootTest
class SefazApplicationTests {

	
		Usuario usuarioTest1;
		Usuario usuarioTest2;
		Usuario usuarioTest3;
		Usuario usuarioTest4;
		Usuario usuarioTest5;
		UsuarioControlador ur = new UsuarioControlador();
		UsuarioControlador ur2 = new UsuarioControlador();
		ArrayList<Telefone> telefone = new ArrayList<Telefone>();
		Telefone telefone1 = new Telefone();

//		@Before
		public void loadUsuariosTest(){

			usuarioTest2 = new Usuario();
			usuarioTest2.setCpf("12345678902");
			usuarioTest2.setNome("usuario2");
			usuarioTest2.setEmail("customer1@gmail.com");
			usuarioTest2.setSenha("1234");
			telefone1.setCod((long) 857);
			telefone1.setDdd("81");
			telefone1.setNumero("123456789");
			telefone1.setTipo("fixo");
			telefone.add(telefone1);
			telefone.add(telefone1);
			usuarioTest2.setTelefones(telefone);


			usuarioTest3 = new Usuario();
			usuarioTest3.setCpf("12345678903");
			usuarioTest3.setNome("usuario3");
			usuarioTest3.setEmail("customer1@gmail.com");
			usuarioTest3.setSenha("1234");
			telefone1.setCod((long) 858);
			telefone1.setDdd("81");
			telefone1.setNumero("123456789");
			telefone1.setTipo("fixo");
			telefone.add(telefone1);
			telefone.add(telefone1);
			usuarioTest3.setTelefones(telefone);

			usuarioTest4 = new Usuario();
			usuarioTest4.setCpf("12345678904");
			usuarioTest4.setNome("usuario4");
			usuarioTest4.setEmail("customer1@gmail.com");
			usuarioTest4.setSenha("1234");
			telefone1.setCod((long) 859);
			telefone1.setDdd("81");
			telefone1.setNumero("123456789");
			telefone1.setTipo("fixo");
			telefone.add(telefone1);
			telefone.add(telefone1);
			usuarioTest4.setTelefones(telefone);



			usuarioTest5 = new Usuario();
			usuarioTest5.setCpf("12345678905");
			usuarioTest5.setNome("usuario5");
			usuarioTest5.setEmail("customer1@gmail.com");
			usuarioTest5.setSenha("1234");
			telefone1.setCod((long) 860);
			telefone1.setDdd("81");
			telefone1.setNumero("123456789");
			telefone1.setTipo("fixo");
			telefone.add(telefone1);
			telefone.add(telefone1);
			usuarioTest5.setTelefones(telefone);



				ur.salvar(usuarioTest1);

		}

		//  Testando a busca por todos os usuarios
		@Test
		public void getUsuariosTest() throws GeneralException{
			Iterable<Usuario> usuarioList = null;
			ur.salvar(usuarioTest1);
			usuarioList = ur.listar();
			Assert.notNull(usuarioList);
		}

		//  Testando a busca por um usuario
		@Test
		public void getUsuarioTest() throws GeneralException{
			
			Iterable<Usuario> usuario = ur.listar();
			//Usuario usuario1 = ur.buscarUsuario((long) 3);
			Assert.notNull(usuario);
			//Assert.notNull(usuario1);
		}

		//  Testando se a excessão de Usuario Inexistente está funcionando
		@Test
		public void getUsuarioInexistenteTest(){
			long id = 3;

			try {
				Usuario usuarioTest = ur.buscarUsuario(id);
			} catch (GeneralException e) {
//				Assert.assertEquals(e.getMessage(), "Usuario Não Existe!");
			}
		}

		// Testando adição de usuario
		@Test
		public void addUsuarioTest() throws GeneralException {
			Iterable<Usuario> usuarios = ur.listar();
			int contagemAntes = ur.contar(usuarios);
			ur.salvar(usuarioTest2);

			Iterable<Usuario> usuarios2 = ur.listar();
			int contagemDepois = ur.contar(usuarios2);

//			Assert.assertEquals(contagemAntes + 1, contagemDepois);
		}

		// Testando adição de usuario Existente
		@Test
		public void addUsuarioExistenteTest(){

			usuarioTest3.setCpf("12345678902");
			try {
				ur.salvar(usuarioTest1);
			} catch (Exception e) {
//				Assert.assertEquals("Usuário já cadastrado!", e.getMessage());
			}		
		}


		// Testando merge de usuario 
		@Test
		public void mergeUsuarioTest() throws GeneralException{
			String cpf = "12345678902";
			long id = 1;

			usuarioTest4.setCpf(cpf);

			ur.atualizar(usuarioTest4.getId());
			Usuario usuarioTesteDepois = ur.buscarUsuario(id);

			//Assert.assertEquals(usuarioTesteDepois.getNome(), usuarioTest4.getNome());
			//Assert.assertEquals(usuarioTesteDepois.getEmail(), usuarioTest4.getEmail());

		}

		@Test
		public void deleteUsuarioTeste() throws GeneralException{
			
			//usuarioTest1 = new Usuario("12345678901","usuario1", "customer1@gmail.com","1234");
			
			telefone1.setCod((long) 856);
			telefone1.setDdd("81");
			telefone1.setNumero("123456789");
			telefone1.setTipo("fixo");
			telefone.add(telefone1);
			telefone.add(telefone1);
			usuarioTest1.setTelefones(telefone);
			
			//System.out.println(usuarioTest1.getCpf());
			//ur.salvar(usuarioTest1);
			Iterable<Usuario> usuariosAntes = ur.listar();
			int contagemInicial = ur.contar(usuariosAntes);
			
			usuarioTest1.setId(5);
			ur.remover(usuarioTest1.getId());

			Iterable<Usuario> usuariosDepois = ur.listar();
			int contagemFinal = ur.contar(usuariosDepois);

			System.out.println(contagemInicial == contagemFinal);
			//Assert.assertEquals(contagemInicial, contagemFinal);
		}

//		@After
		public void cleanTest(){
			ur = ur2;
		}
	
	}
