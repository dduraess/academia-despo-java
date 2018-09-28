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
	public void emprestarLivro(String nomeLivro,Usuario usuario) {
		for (Livro livro : livrosCatalogados) {
			if (livro.nome == nomeLivro && livro.usuario != null) {
				livro.anexarUsuario(usuario);
			} break;
		}
	}

}
