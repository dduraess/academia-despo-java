package org.commun.biblioteca.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.commun.biblioteca.Biblioteca;
import org.commun.biblioteca.Livro;
import org.commun.biblioteca.Usuario;
import org.junit.Before;
import org.junit.Test;

public class BibliotecaTest {

	Usuario usuario;
	Usuario usuario2;
	Usuario usuario3;
	Biblioteca biblioteca;
	Livro livro;
	Livro livro2;
	Livro livro3;

	@Before
	public void criarBiblioteca() {
		usuario = new Usuario("Davison");
		usuario2 = new Usuario("Daniel");
		usuario3 = new Usuario("Antonio");
		biblioteca = new Biblioteca();
		livro = new Livro("Macunaima");
		livro2 = new Livro("Vidas Secas");
		livro3 = new Livro("Memórias póstumas de Braz Cubas");
	}
	
	@Test
	public void quantidadeZeroNovaBiblioteca() {
		assertEquals(0, biblioteca.quantidadeUsuariosRegistrados());
	}

	@Test
	public void registrarUsuario() {
		biblioteca.registrarUsuario(usuario);
		assertEquals(1, biblioteca.quantidadeUsuariosRegistrados());
	}

	@Test
	public void quantidadeZeroNovoCatalogoLivros() {
		assertEquals(0, biblioteca.quantidadeLivrosCatalogados());
	}
	
	@Test
	public void quantidadeUmCatalogoLivros() {
		biblioteca.adicionarLivroCatalogo(livro);
		assertEquals(1, biblioteca.quantidadeLivrosCatalogados());
	}
	
	@Test
	public void verificarLivroNaoEmprestadoDisponivel() {
		biblioteca.adicionarLivroCatalogo(livro);
		assertTrue(livro.estaDisponivel());
	}
	
	@Test
	public void verificarLivroEmprestadoNaoDisponivel() {
		biblioteca.adicionarLivroCatalogo(livro);
		biblioteca.adicionarLivroCatalogo(livro2);
		biblioteca.registrarUsuario(usuario);
		biblioteca.registrarUsuario(usuario2);
		biblioteca.emprestarLivro(livro2, usuario);
		assertTrue(!livro2.estaDisponivel() && livro2.getUsuarioAtual().equals(usuario.getNome()));
	}
	
	@Test
	public void verificarLivroDevolvidoDisponivel() {
		biblioteca.adicionarLivroCatalogo(livro);
		biblioteca.adicionarLivroCatalogo(livro2);
		biblioteca.adicionarLivroCatalogo(livro3);
		biblioteca.registrarUsuario(usuario);
		biblioteca.registrarUsuario(usuario2);
		biblioteca.registrarUsuario(usuario3);
		biblioteca.emprestarLivro(livro2, usuario);
		biblioteca.devolverLivro(livro2, usuario);
		assertTrue(livro2.estaDisponivel());
	}
	
	@Test
	public void verificarLivroNaoDevolvidoIndisponivel() {
		biblioteca.adicionarLivroCatalogo(livro);
		biblioteca.adicionarLivroCatalogo(livro2);
		biblioteca.adicionarLivroCatalogo(livro3);
		biblioteca.registrarUsuario(usuario);
		biblioteca.registrarUsuario(usuario2);
		biblioteca.registrarUsuario(usuario3);
		biblioteca.emprestarLivro(livro2, usuario);
		biblioteca.emprestarLivro(livro3, usuario);
		biblioteca.devolverLivro(livro2, usuario);
		assertTrue(!livro3.estaDisponivel() && livro2.estaDisponivel());
	}
	
	@Test
	public void imprimirListaDeLivrosDisponiveisEEmprestados() {
		biblioteca.adicionarLivroCatalogo(livro);
		biblioteca.adicionarLivroCatalogo(livro2);
		biblioteca.adicionarLivroCatalogo(livro3);
		biblioteca.registrarUsuario(usuario);
		biblioteca.registrarUsuario(usuario2);
		biblioteca.registrarUsuario(usuario3);
		biblioteca.emprestarLivro(livro2, usuario);
		biblioteca.emprestarLivro(livro3, usuario2);
		biblioteca.devolverLivro(livro2, usuario);
		System.out.println(biblioteca.listaLivrosDisponiveis());
		System.out.println(biblioteca.listaLivrosEmprestados());
	}

}
