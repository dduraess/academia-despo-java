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
	Biblioteca biblioteca;
	Livro livro;

	@Before
	public void criarBiblioteca() {
		usuario = new Usuario("Davison");
		biblioteca = new Biblioteca();
		livro = new Livro("Macunaima");
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
		biblioteca.registrarUsuario(usuario);
		biblioteca.emprestarLivro(livro, usuario);
		assertTrue(!livro.estaDisponivel());
	}

}
