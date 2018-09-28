package org.commun.biblioteca;

public class Livro {
	String nome;
	Usuario usuario;
	
	public Livro(String nome){
		this.nome = nome;
	}
	public void anexarUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
