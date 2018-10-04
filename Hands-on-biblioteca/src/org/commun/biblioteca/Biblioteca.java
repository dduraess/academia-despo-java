package org.commun.biblioteca;

import java.util.ArrayList;
import java.util.Collection;

public class Biblioteca {
	private Collection<Usuario> usuariosRegistrados;
	private Collection<Livro> livrosCatalogados;
	
	public Biblioteca(){
		this.usuariosRegistrados = new ArrayList<>();
		this.livrosCatalogados = new ArrayList<>();
	}
	
	public void registrarUsuario(Usuario usuario) {
		this.usuariosRegistrados.add(usuario);
		
	}
	
	public int quantidadeUsuariosRegistrados() {
		return this.usuariosRegistrados.size();
	}
	
	public void adicionarLivroCatalogo(Livro livro) {
		this.livrosCatalogados.add(livro);
	}
	
	public int quantidadeLivrosCatalogados() {
		return this.livrosCatalogados.size();
	}
	
	public void emprestarLivro(Livro livroDesejado, Usuario usuario) {
		for (Livro livro : livrosCatalogados) {
			if (livroDesejado.getNome().equals(livro.getNome()) && livro.estaDisponivel()) {
				livro.anexarUsuario(usuario);
				usuario.incluirLivroEmprestadoNaListaDoUsuario(livroDesejado);
			} 
		}
	}
	
	public void devolverLivro(Livro livroEntregue, Usuario usuario) {
		for (Livro livro : livrosCatalogados) {
			if (livroEntregue.getNome().equals(livro.getNome()) && livro.getUsuarioAtual().equals(usuario.getNome())) {
				livro.desanexarUsuario(usuario);
			} 
		}
	}
	
	public String listaLivrosDisponiveis() {
		String listaLivrosDisponiveis = "Lista de livros disponíveis: \n";
		for (Livro livro : livrosCatalogados) {
			if (livro.estaDisponivel()) {
				listaLivrosDisponiveis += livro.getNome() + "\n";
			} 
		}
		return listaLivrosDisponiveis;
	}
	
	public String listaLivrosEmprestados() {
		String listaLivrosEmprestados = "Lista de livros emprestados: \n";
		for (Livro livro : livrosCatalogados) {
			if (!livro.estaDisponivel()) {
				listaLivrosEmprestados += livro.getNome() + " emprestado para " + livro.getUsuarioAtual() + "\n";
			} 
		}
		return listaLivrosEmprestados;
	}

}
