package org.commun.biblioteca;

public class Livro {
	String nome;
	String usuarioAtual;
	
	public Livro(String nome){
		this.nome = nome;
		this.usuarioAtual = "";
	}
	
	public void anexarUsuario(Usuario usuario) {
		usuarioAtual = usuario.nome;
	}
	
	public boolean estaDisponivel() {
		if (usuarioAtual.equals("")) {
			return true;			
		} return false;
	}
	
}
