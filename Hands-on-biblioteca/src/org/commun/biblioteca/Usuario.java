package org.commun.biblioteca;

import java.util.ArrayList;
import java.util.Collection;

public class Usuario {
	
	private String nome;
	private Collection<Livro> livrosEmprestados = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public Usuario(String nome){
		this.nome = nome;
	}
	
	public void incluirLivroEmprestadoNaListaDoUsuario (Livro livro) {
		livrosEmprestados.add(livro);
	}
}
