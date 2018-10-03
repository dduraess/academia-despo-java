package org.commun.biblioteca;

import java.util.ArrayList;
import java.util.Collection;

public class Usuario {
	
	String nome;
	Collection<Livro> livrosEmprestados = new ArrayList<>();

	public Usuario(String nome){
		this.nome = nome;
	}
	
	public void incluirLivroEmprestadoNaListaDoUsuario (Livro livro) {
		livrosEmprestados.add(livro);
	}
}
